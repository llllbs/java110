package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherAddController {
    
    @RequestMapping("teacher/add")
    public void add(Scanner keyIn) {

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
            
            if(App.teacherDao.insert(m)>0) {
                System.out.println("저장 되었습니다");
            }else {
                System.out.println("동일한 이메일이 존재합니다.");
            }
            
           
            System.out.print("계속하시겠습니까? (Y/n) ");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {

                break;

            }

        }

    }

}
