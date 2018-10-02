// 세션 생성, 소멸 모니터링 하기
package bitcamp.java110.ex11;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener01 implements HttpSessionListener {
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // TODO Auto-generated method stub
        System.out.printf("ex11.Listener01.sessionCreated():%s\n",se.getSession().getId());
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // TODO Auto-generated method stub
        System.out.printf("ex11.Listener01.sessionDestroyed:%s\n",se.getSession().getId());
    }

}
