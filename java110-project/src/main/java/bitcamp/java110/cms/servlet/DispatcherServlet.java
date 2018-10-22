package bitcamp.java110.cms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.web.PageController;


public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 클라이언트가 요청한 URL에서 /app 다음에 지정한 경로를 추출한다
        String pageControllerPath = request.getPathInfo();

        // 스프링 IoC 컨테이너 가져오기
        ApplicationContext iocContainer = 
                (ApplicationContext)this.getServletContext().getAttribute("iocContainer");

        // IoC 컨테이너에서 페이지 컨트롤러를 찾는다
        try {
            PageController controller = (PageController)iocContainer.getBean(pageControllerPath);

            String viewUrl = controller.service(request, response);


            if(viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));

            }else {

                // 페이지 컨트롤러가 지정한 URL을 실행
                response.setContentType("text/html;charset=UTF-8");//JSP보낼 때 꼭 붙이기
                RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
                rd.include(request, response);

            }

        }catch(Exception e) {
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("error", e);
            request.setAttribute("message", "실행 오류!");
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.include(request, response);

        }

    }

}
