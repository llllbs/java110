package bitcamp.java110.cms.server;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ServerApp {

    ClassPathXmlApplicationContext iocContainer;
    RequestMappingHandlerMapping requestHandlerMap;

    public ServerApp() throws Exception{
        createIoCContainer();
        logBeansOfContainer();
        processRequestMappingAnnotation();

    }

    private void createIoCContainer() {
        iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java110/cms/conf/application-context.xml");

    }

    private void processRequestMappingAnnotation() {
        requestHandlerMap = new RequestMappingHandlerMapping();

        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            Object obj = iocContainer.getBean(name);
            requestHandlerMap.addMapping(obj);
        }   
    }

    private void logBeansOfContainer() {

        System.out.println("---------------------------------");

        String[] nameList = iocContainer.getBeanDefinitionNames();
        for(String name: nameList) {
            System.out.println(name);
        }

        System.out.println("---------------------------------");

    }

    public void service() throws Exception{

        // 클라이언트 연결을 기다리는 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(8888 /*대기열은 큐방식 으로 사용-> 먼저 들어가면 먼저 나옴(Node.js가 이렇게 동작)*/);
        System.out.println("서버 실행 중...");

        while(true) {
            Socket socket = serverSocket.accept();
            RequestWorker worker = new RequestWorker(socket);
            new Thread(worker).start();
            // 메인스레드에서 만든 스레드는 메인스레드의 자식스레드라고 한다

        }

    }

    public static void main(String[] args) throws Exception {
        ServerApp serverApp = new ServerApp();
        serverApp.service();


    }

    class RequestWorker implements Runnable{
        Socket socket;

        public RequestWorker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            //이 메서드에 "main"스레드에서 분리하여 독립적으로 수행할 코드를 둔다.

            try (
                    Socket socket = this.socket; 
                    // 여기 값이 있어야지 try블록에 벗어날때 close 자동 호출할 수 있다
                    PrintWriter out = new PrintWriter(
                            new BufferedOutputStream(
                                    socket.getOutputStream()));

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
                    ){
                System.out.println(in.readLine());
                out.println("OK: 이세영임니다"); out.flush();

                while(true) {
                    String requestLine = in.readLine();
                    if(requestLine.equals("EXIT")) {
                        out.println("goodbye");
                        out.println();
                        out.flush();
                        break;
                    }

                    // 요청 객체 준비
                    Request request = new Request(requestLine);

                    // 응답 객체 준비
                    Response response = new Response(out);

                    RequestMappingHandler mapping = requestHandlerMap.getMapping(request.getAppPath());
                    if (mapping == null) {
                        out.println("해당 요청을 처리할 수 없습니다.");
                        out.println();
                        out.flush();
                        continue;
                    }


                    try {
                        // 요청 핸들러 호출(requestHandler)
                        mapping.getMethod().invoke(mapping.getInstance(), request, response);

                    } catch (Exception e) {
                        e.printStackTrace();// 서버 콘솔창에 출력
                        out.println("요청 처리 중에 오류가 발생했습니다."); 
                    }
                    out.println();
                    out.flush();
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }//run()

    }//RequestWorker class

}// ServerApp class






















