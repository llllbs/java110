package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherListController {
    
    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        for(int i=0; i<App.teachers.size();i++) {// 배열이나 컬렉션이 들어감
           
            Teacher s = App.teachers.get(i);
            
            System.out.printf("%d: %s, %s, %s, %s, %d, [%s]\n"//%d 숫자
                    , s.getName()
                    , s.getEmail()
                    , s.getPassword()
                    , s.getTel()
                    , s.getPay()
                    , s.getSubjects());

        }

    }

}
