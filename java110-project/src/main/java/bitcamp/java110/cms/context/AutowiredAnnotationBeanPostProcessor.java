package bitcamp.java110.cms.context;

import java.lang.reflect.Method;
import java.util.Collection;

import bitcamp.java110.cms.annotation.Autowired;


public class AutowiredAnnotationBeanPostProcessor implements BeanPostProcessor{

    ApplicationContext beanContainer;

    public void postProcess(ApplicationContext beanContainer) {

     // objPool?— ë³´ê??œ ê°ì²´ ëª©ë¡?„ êº¼ë‚¸?‹¤.
        Collection<Object> objList = beanContainer.objPool.values();
        
        for (Object obj : objList) {
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method m : methods) {
                if (!m.isAnnotationPresent(Autowired.class)) continue;
                
                // setter ë©”ì„œ?“œ?˜ ?ŒŒ?¼ë¯¸í„° ???…?„ ?•Œ?•„?‚¸?‹¤.
                Class<?> paramType = m.getParameterTypes()[0];
                
                // ê·? ?ŒŒ?¼ë¯¸í„° ???…ê³? ?¼ì¹˜í•˜?Š” ê°ì²´ê°? objPool?—?„œ êº¼ë‚¸?‹¤.
                Object dependency = beanContainer.getBean(paramType);
                
                if (dependency == null) continue;
                
                try {
                    m.invoke(obj, dependency);
                    System.out.printf("%s() ?˜¸ì¶œë¨\n", m.getName());
                } catch (Exception e) {}
            }
        }
    }
    
}
