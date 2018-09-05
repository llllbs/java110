import java.util.Scanner;

public class ManagerController {

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

    static Manager[] managers = new Manager[100];
    static Scanner keyIn;
    static int ManagerIndex = 0;

    static void serviceManagerMenu() {
        while (true) {
            System.out.println("매니저 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printManagers();

            } else if (command.equals("add")) {
                inputManagers();

            } else if (command.equals("quit")) {
                break;

            } else {
                System.out.println("유효하지 않는 명령입니다.");

            }
        }
    }

    static void printManagers() {
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

    static void inputManagers() {

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

            managers[ManagerIndex++] = m;// 현재 index 값을 이 자리에 넣기(후위 연산자)

            System.out.print("계속하시겠습니까? (Y/n) ");// 대문자 Y는 default값이 Y라는 것
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n")) {

                break;

            }

        }

    }
}

