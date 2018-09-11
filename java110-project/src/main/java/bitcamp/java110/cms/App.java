package bitcamp.java110.cms;
import java.util.Scanner;

import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.context.ResuestMappingHandlerMapping;
import bitcamp.java110.cms.context.ResuestMappingHandlerMapping.RequestMappingHandler;


public class App {

    // 여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.

    public static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ApplicationContext iocContainer = new ApplicationContext("bitcamp.java110.cms");

        ResuestMappingHandlerMapping requestHandlerMap = new ResuestMappingHandlerMapping();
        // -> IoC 컨테이너에 보관된 객체의 이름 목록을 가져온다
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            Object obj = iocContainer.getBean(name);
            requestHandlerMap.addMapping(obj);
        }
        while(true) {

            String menu = prompt();

            if(menu.equals("exit")){
                System.out.println("안녕히 가세요!");
                break;
            }

            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);
            if(mapping == null) {
                System.out.println("해당 메뉴가 없습니다");
                continue;
            }


            mapping.getMethod().invoke(mapping.getInstance(),keyIn);

        }

        keyIn.close(); // scanner는 사용 후 닫아주기

    }



    private static String prompt() {

        System.out.println("메뉴> ");
        return keyIn.nextLine();



    }
}

