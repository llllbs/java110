package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class StudentController {
    
    static Student[] students = new Student[100];
    public static Scanner keyIn;
    static int studentIndex = 0;

    static class Student extends Member {
        protected String school;
        protected boolean working;
        protected String tel;

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public boolean isWorking() {// boolean 일 경우 is로 시작
            return working;
        }

        public void setWorking(boolean working) {
            this.working = working;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }

    

    public static void serviceStudentMenu() {
        while (true) {
            System.out.println("학생 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printStudents();

            } else if (command.equals("add")) {
                inputStudents();

            } else if (command.equals("quit")) {
                break;

            } else {
                System.out.println("유효하지 않는 명령입니다.");

            }
        }
    }

    private static void printStudents() {
        int count = 0;

        for (Student s : students) {// 배열이나 컬렉션이 들어감
            if (count++ == studentIndex)// 증가된 값과 비교하는게 아니다
                break;
            System.out.printf("%s, %s, %s, %s, %b, %s\n"
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getSchool()
                    , s.isWorking()
                    , s.getTel());

        }

    }

    private static void inputStudents() {

        while (true) {
            Student m = new Student();

            System.out.print("이름? ");
            m.setName(keyIn.nextLine());

            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());

            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());

            System.out.print("최종학력? ");
            m.setSchool(keyIn.nextLine());

            System.out.print("재직여부? (true/false) ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));

            students[studentIndex++] = m;// 현재 index 값을 이 자리에 넣기(후위 연산자)

            System.out.print("계속하시겠습니까? (Y/n) ");// 대문자 Y는 default값이 Y라는 것
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n")) {

                break;

            }

        }

    }
}
