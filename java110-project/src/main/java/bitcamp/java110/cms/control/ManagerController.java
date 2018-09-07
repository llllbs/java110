package bitcamp.java110.cms.control;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Manager;

// member는 bitcamp.java110.cms.domain.Member; 여기에 있다는 것을 알려주기만 함


public class ManagerController implements Controller {
    
    private List<Manager> managers;
    public Scanner keyIn;
    
    public ManagerController(List<Manager> managers) {
        this.managers = managers;
    }

    public void service(Scanner keyIn) {
        while (true) {
            System.out.println("매니저 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printManagers();

            } else if (command.equals("add")) {
                inputManagers(keyIn);

            } else if (command.equals("delete")) {
                deleteManager(keyIn);

            } else if (command.equals("detail")) {
                detailManager(keyIn);

            } else if (command.equals("quit")) {
                break;

            } else {
                System.out.println("유효하지 않는 명령입니다.");

            }
        }
    }

    private void printManagers() {

        for (int i=0; i<managers.size();i++) {
            
            Manager s = managers.get(i);
           
            System.out.printf("%d: s, %s, %s, %s, %s\n"
                    , i
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPosition());

        }

    }

    private void inputManagers(Scanner keyIn) {

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
            
            managers.add(m);

            System.out.print("계속하시겠습니까? (Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n")) {

                break;

            }

        }

    }
    
    
    private void deleteManager(Scanner keyIn) {
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        managers.remove(no);

        System.out.println("삭제 하였습니다.");

    }

    private void detailManager(Scanner keyIn) {
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Manager manager = managers.get(no);
        
        System.out.printf("이름: %s\n",manager.getName());
        System.out.printf("이메일: %s\n", manager.getEmail());
        System.out.printf("암호: %s\n", manager.getPassword());
        System.out.printf("전화: %s\n", manager.getTel());
        System.out.printf("재적여부: %s\n", manager.getPosition());
        //boolean이라서 %b사용

    }
    
    
}
