package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentdeleteController {
      
    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {

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



            System.out.print("재직여부?(true/false) ");

            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));



            System.out.print("전화? ");

            m.setTel(keyIn.nextLine());



            App.students.add(m);
         



            System.out.println("계속 하시겠습니까?(Y/n) ");

            String answer = keyIn.nextLine();

            if (answer.toLowerCase().equals("n")) {

                break;

            }

        }



    }

}
