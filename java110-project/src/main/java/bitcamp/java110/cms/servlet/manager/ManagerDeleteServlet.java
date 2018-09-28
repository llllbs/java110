package bitcamp.java110.cms.servlet.manager;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;

@WebServlet("/manager/delete")
public class ManagerDeleteServlet extends HttpServlet { 

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
      
        int no = Integer.parseInt(request.getParameter("no"));

        ManagerDao managerDao = (ManagerDao)this.getServletContext()
                .getAttribute("managerDao");


        try {
            managerDao.delete(no);
            response.sendRedirect("list");
            
        } catch(Exception e) {
            e.printStackTrace();
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Refresh", "1;url = list");
            
            PrintWriter out = response.getWriter();
            out.println("<p>삭제 중 오류 발생!</p>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>매니저 관리</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>매니저 삭제오류</h1>");
            out.printf("<p>%s</p>\n", e.getMessage());
            out.println("<p>잠시 기다리시면 목록페이지로 다시 이동합니다.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}// end class









