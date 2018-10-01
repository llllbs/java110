package bitcamp.java110.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/footer")
public class FotterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
       
        out.println("<footer>");
        out.println("<p>&copy;자바110기</p>");
            
        out.println("<ul>");
        out.println("<li>학생관리</li>");
        out.println("<li>강사관리</li>");
        out.println("<li>매니저관리</li>");
        out.println("</ul>");
        out.println("</header>");
        
       
    }

}
