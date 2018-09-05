package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;
// member는 bitcamp.java110.cms.domain.Member; 여기에 있다는 것을 알려주기만 함


public class ManagerController {
    
    static Manager[] managers = new Manager[100];
    public static Scanner keyIn;
    static int ManagerIndex = 0;

    static class Manager extends Member{
        protected String tel;
        protected String position;

        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }


    }

    

    public static void serviceManagerMenu() {
        while (true) {
            System.out.println("매니저 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printManagers();

            } else if (command.equals("add")) {
                inputManagers();

            } else if (command.equals("delete")) {
                deleteManager();

            } else if (command.equals("detail")) {
                detailManager();

            } else if (command.equals("quit")) {
                break;

            } else {
                System.out.println("유효하지 않는 명령입니다.");

            }
        }
    }

    private static void printManagers() {
        int count = 0;

        for (Manager s : managers) {// 배열이나 컬렉션이 들어감
            if (count++ == ManagerIndex)// 증가된 값과 비교하는게 아니다
                break;
            System.out.printf("%s, %s, %s, %s, %s\n"
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPosition());

        }

    }

    private static void inputManagers() {

        while (true) {
            Manager m = new Manager();

            System.out.print("이름? ");
            m.setName(keyIn.nextLine());

            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());

            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());

            System.out.print("전화번호? ");
            m.setTel(keyIn.nextLine());

            System.out.print("직위? ");
            m.setPosition(keyIn.nextLine());
            
            if(ManagerIndex == managers.length) {
                increaseStorage();
            }

            managers[ManagerIndex++] = m;// 현재 index 값을 이 자리에 넣기(후위 연산자)

            System.out.print("계속하시겠습니까? (Y/n) ");// 대문자 Y는 default값이 Y라는 것
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n")) {

                break;

            }

        }

    }
    
    private static void increaseStorage() {
        Manager[] newList = new Manager[managers.length +3 ];
        for(int i=0; i<managers.length; i++) {
            newList[i] = managers[i];
        }
        managers = newList;
    }
    private static void deleteManager() {
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= ManagerIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        for(int i = no; i<ManagerIndex-1; i++) {// 가르키는 범위가 삭제 될때
            managers[i] = managers[i+1];
        }
        ManagerIndex --;

        System.out.println("삭제 하였습니다.");

    }

    private static void detailManager() {
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= ManagerIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        System.out.printf("이름: %s\n", managers[no].getName());
        System.out.printf("이메일: %s\n", managers[no].getEmail());
        System.out.printf("암호: %s\n", managers[no].getPassword());
        System.out.printf("전화: %s\n", managers[no].getTel());
        System.out.printf("재적여부: %s\n", managers[no].getPosition());
        //boolean이라서 %b사용

    }
    
    
}

