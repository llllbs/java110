/*서블릿 만들기
 * - javax.servlet.GenericServlet 상속받기
 * 
 */


package bitcamp.java110.ex02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex02/servlet02")
public class Servlet02 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    // 추상 클래스  GEnericServlet

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        System.out.println("Servlet02.service() 호출됨");
        
    }

}// end class