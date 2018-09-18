package bitcamp.java110.cms.control;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class StudentController {

    StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @RequestMapping("student/add")
    public void add(Request request, Response response) {
        Student m = new Student();

        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setSchool(request.getParameter("school"));
        m.setWorking(Boolean.parseBoolean(request.getParameter("working")));

        studentDao.insert(m);

        PrintWriter out = response.getWriter();
        out.println("등록하였습니다");
    }

    @RequestMapping("student/delete")
    public void delete(Request request, Response response) {
        int no = Integer.parseInt(request.getParameter("no"));
        PrintWriter out = response.getWriter();

        if (studentDao.delete(no) > 0) {
            out.println("삭제하였습니다.");
        } else {
            out.println("번호에 해당하는 학생이 없습니다.");
        }
    }

    @RequestMapping("student/detail")
    public void detail(Request request, Response response) {
        int no = Integer.parseInt(request.getParameter("no"));

        Student s = studentDao.findByNo(no);
        PrintWriter out = response.getWriter();

        if (s == null) {
            out.println("해당 번호의 학생 정보가 없습니다!");
            return;
        }

        out.printf("이름: %s\n", s.getName());
        out.printf("이메일: %s\n", s.getEmail());
        out.printf("암호: %s\n", s.getPassword());
        out.printf("최종학력: %s\n", s.getSchool());
        out.printf("전화: %s\n", s.getTel());
        out.printf("재직여부: %b\n", s.isWorking());
    }

    @RequestMapping("student/list")
    public void list(Request request, Response response) {
        PrintWriter out = response.getWriter();

        List<Student> list = studentDao.findAll();
        for (Student s : list) {
            out.printf("%d, %s, %s, %s, %b\n",
                    s.getNo(),
                    s.getName(), 
                    s.getEmail(), 
                    s.getSchool(),
                    s.isWorking());
        }
    }
}
