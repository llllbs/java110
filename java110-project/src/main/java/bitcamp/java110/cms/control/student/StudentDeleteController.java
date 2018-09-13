package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;

@Component
public class StudentDeleteController {
    StudentDao studentDao;


    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 학생의 이메일? ");
        
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(studentDao.deleteByNo(no)>0) {
            System.out.println("삭제 하였습니다.");
        }else {
            System.out.println("삭제할 번호의 학생이 없습니다.");
        }

    }

}
