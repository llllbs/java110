package ex01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class MyWebApplicationIniializer3 implements WebApplicationInitializer {
    
    @Override
    public void onStartup(ServletContext servletContext) /*throws ServletException*/ {
        
        
        System.out.println("MyWebApplicationInitializer3");
        
    }

}
