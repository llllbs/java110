import java.util.Scanner;

import bitcamp.java110.cms.control.ManagerController;
import bitcamp.java110.cms.control.StudentController;
import bitcamp.java110.cms.control.TeacherController;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.util.ArrayList;
import bitcamp.java110.cms.util.LinkedList;

public class App {

    // 여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {
        

        StudentController sc = new StudentController(keyIn, new LinkedList<Student>());
        ManagerController mc = new ManagerController(keyIn, new ArrayList<Manager>());
        TeacherController tc = new TeacherController(keyIn, new ArrayList<Teacher>());

        while(true) {

            String menu = promptMenu();

            if(menu.equals("1")) {
                sc.serviceStudentMenu();

            }else if(menu.equals("2")) {
                tc.serviceTeacherMenu();

            }else if(menu.equals("3")) {
                mc.serviceManagerMenu();

            } else if(menu.equals("0")){
                System.out.println("안녕히 가세요!");
                break;

            }
        }


        keyIn.close(); // scanner는 사용 후 닫아주기

    }


    private static String promptMenu() {
        System.out.println("[메뉴]");
        System.out.println("1. 학생 관리");
        System.out.println("2. 강사 관리");
        System.out.println("3. 매니저 관리");
        System.out.println("0. 종료");

        while(true) {
            System.out.print("메뉴 번호> ");

            String menu = keyIn.nextLine();

            switch(menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;

            default:
                System.out.println("메뉴 번호가 유효하지 않습니다.");

            }
        }
    }
}











