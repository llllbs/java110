package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.control.StudentController.Student;
import bitcamp.java110.cms.domain.Member;

public class TeacherController { //패키지 클래스(패키지 멤버 클래스): 무조건 public
    
    static int teacherIndex = 0;
    public static Scanner keyIn;
    static Teacher[] teachers = new Teacher[100];

    static class Teacher extends Member{
        protected String tel;
        protected int pay;
        protected String subjects;

        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }

    }
   


    public static void serviceTeacherMenu() {
        while(true) {
            System.out.println("강사 관리> ");
            String command = keyIn.nextLine();

            if(command.equals("list")) {
                printTeachers();

            }else if(command.equals("add")) {
                inputTeachers();

            }else if (command.equals("delete")) {
                deleteTeacher();

            }else if (command.equals("detail")) {
                detailTeacher();

            }else if(command.equals("quit")) {
                break;

            }else {
                System.out.println("유효하지 않는 명령입니다.");

            }
        }
    }

    private static void printTeachers() {
        int count = 0;

        for(Teacher s : teachers) {// 배열이나 컬렉션이 들어감
            if(count++ == teacherIndex)// 증가된 값과 비교하는게 아니다
                break;
            System.out.printf("%s, %s, %s, %s, %d, [%s]\n"//%d 숫자
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPay()
                    , s.getSubjects());

        }

    }

    private static void inputTeachers() {

        while(true) {
            Teacher m = new Teacher();


            System.out.print("이름? ");
            m.setName(keyIn.nextLine());

            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());

            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());

            System.out.print("전화번호? ");
            m.setTel(keyIn.nextLine());

            System.out.print("시급? ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));

            System.out.print("과목? ");
            m.setSubjects(keyIn.nextLine());

            teachers[teacherIndex++] = m;// 현재 index 값을 이 자리에 넣기(후위 연산자)

            System.out.print("계속하시겠습니까? (Y/n) ");// 대문자 Y는 default값이 Y라는 것
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {

                break;

            }

        }

    }
    private static void increaseStorage() {
        Teacher[] newList = new Teacher[teachers.length +3 ];
        for(int i=0; i<teachers.length; i++) {
            newList[i] = teachers[i];
        }
        teachers = newList;
    }
    private static void deleteTeacher() {
        System.out.print("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= teacherIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        for(int i = no; i<teacherIndex-1; i++) {// 가르키는 범위가 삭제 될때
            teachers[i] = teachers[i+1];
        }
        teacherIndex --;

        System.out.println("삭제 하였습니다.");

    }

    private static void detailTeacher() {
        System.out.print("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no < 0 || no >= teacherIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        System.out.printf("이름: %s\n", teachers[no].getName());
        System.out.printf("이메일: %s\n", teachers[no].getEmail());
        System.out.printf("암호: %s\n", teachers[no].getPassword());
        System.out.printf("최종학력: %s\n", teachers[no].getTel());
        System.out.printf("전화: %d\n", teachers[no].getPay());
        System.out.printf("재적여부: %s\n", teachers[no].getSubjects());
        //boolean이라서 %b사용

    }

}
