package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherDetailController {
    
    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 이메일은? ");
        String email = keyIn.nextLine();
        
        Teacher teacher = App.teacherDao.findByEmail(email);
        
        System.out.printf("이름: %s\n", teacher.getName());
        System.out.printf("이메일: %s\n", teacher.getEmail());
        System.out.printf("암호: %s\n", teacher.getPassword());
        System.out.printf("최종학력: %s\n", teacher.getTel());
        System.out.printf("전화: %d\n", teacher.getPay());
        System.out.printf("재적여부: %s\n", teacher.getSubjects());
        //boolean이라서 %b사용

    }

}
