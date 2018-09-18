package bitcamp.java110.cms.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HTTPClient {
    public static void main(String []args) throws Exception {
        try(
                Socket socket = new Socket("www.etnews.co.kr", 80);

                PrintStream out = new PrintStream(socket.getOutputStream());
                Scanner in = new Scanner(socket.getInputStream());
                ){

            //HTTP 요청
            //1) request-line
            out.println("GET / HTTP/1.1");

            //2) 요청 헤더(general header| request header |entity header)
            out.println("Host: www.zdnet.co.kr");
            out.println("Connection: keep-alive");
            out.println("User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) "
                    + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
            // user-agent는 웹이 누군지 말해준다

            out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            // 나의 요구사항에 대해 html을 달라고 함 text/html부터 순차적으로 요구

            out.println("Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");
            // 내가 좋아하는 언어가 뭔지 알려줌(기본-한국어)

            //3) 헤더 끝을 표시
            out.println();

            //4) 서버에 보낼 데이터[message-body]
            //-> 없으면 생략

            while(true) {
                String str = in.nextLine();
                System.out.println(str);
            }  
        }
    }

}
