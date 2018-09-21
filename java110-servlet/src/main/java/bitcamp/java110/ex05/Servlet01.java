/* GET/POST 구분하기
 * 
 */


package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/ex05/servlet01")
public class Servlet01 extends GenericServlet {
    private static final long serialVersionUID = 1L;


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        // 테스트:
        // -> http://localhost:8888/ex05/test.html
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        
        HttpServletRequest httpReq = (HttpServletRequest)req;
        String method = httpReq.getMethod();// get인지 post인지 구분해줌
        
        if(method.equals("GET")) {
            out.println("GET 요청입니다.");
        }else if(method.equals("POST")) {
            out.println("POST 요청입니다.");
        }else {
            out.println("기타 요청입니다.");
        }
        
        
    }

}// end class
