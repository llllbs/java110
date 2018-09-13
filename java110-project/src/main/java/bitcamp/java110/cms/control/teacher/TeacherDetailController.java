package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherDetailController {

    TeacherDao teacherDao;


    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 강사의 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());
        Teacher teacher = teacherDao.findByNo(no);

        if(teacher == null) {
            System.out.println("해당 매니저의 번호가 없습니다.");
            return;
        }


//        Teacher teacher = teacherDao.findByEmail(email);

        System.out.printf("이름: %s\n", teacher.getName());
        System.out.printf("이메일: %s\n", teacher.getEmail());
        System.out.printf("암호: %s\n", teacher.getPassword());
        System.out.printf("최종학력: %s\n", teacher.getTel());
        System.out.printf("전화: %d\n", teacher.getPay());
        System.out.printf("재적여부: %s\n", teacher.getSubjects());
        //boolean이라서 %b사용

    }

}
