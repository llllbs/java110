import java.lang.reflect.Method;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.context.ApplicationContext;

public class App {

    // 여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
//        HashMap<String,Controller> requestHandlerMapping =new HashMap<>();
                
        ApplicationContext iocContainer = new ApplicationContext("bitcamp.java110.cms.control");

        while(true) {

            String menu = prompt();
            
            if(menu.equals("exit")){
                System.out.println("안녕히 가세요!");
                break;
            }
            
            Object controller = iocContainer.getBean(menu);
            if(controller == null) {
                System.out.println("해당 메뉴가 없습니다");
                continue;
            }

            Method method = findRequestMapping(controller.getClass());
            if(method == null) {
                System.out.println("해당 메뉴가 없습니다");
                continue;
            }
                method.invoke(controller,keyIn);
            
        }

        keyIn.close(); // scanner는 사용 후 닫아주기
        
    }


    private static Method findRequestMapping(Class<? extends Object> clazz) {
        //-> 클래스의 메서드 목록을 꺼낸다.
        Method[] methods = clazz.getDeclaredMethods();// 상속받은 메서드 제외
        for(Method m : methods) {
            
            // -> 메서드의 @RequestMapping 정보를 추출한다
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            
            if(anno != null)// 찾았다면 이 메서드를 리턴한다
                return m;
        }
        
        return null;
    }


    private static String prompt() {
        
        System.out.println("메뉴> ");
        return keyIn.nextLine();


            
        }
}













