package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");        
        Student m = new Student();

        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setSchool(request.getParameter("school"));
        m.setWorking(Boolean.parseBoolean(request.getParameter("working")));

        PrintWriter out = response.getWriter();

        StudentDao studentDao = (StudentDao)this.getServletContext()
                .getAttribute("studentDao");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>학생 관리</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>학생 등록결과</h1>");

        try {
            studentDao.insert(m);
            out.println("<p>저장하였습니다.</p>");
        } catch(Exception e) {
            e.printStackTrace();
            out.println("<p>등록중 오류발생</p>");
        }
        out.println("</body>");
        out.println("</html>");

    }


}
