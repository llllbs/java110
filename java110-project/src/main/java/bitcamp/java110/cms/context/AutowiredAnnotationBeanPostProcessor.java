package bitcamp.java110.cms.context;

import java.lang.reflect.Method;
import java.util.Collection;

import bitcamp.java110.cms.annotation.Autowired;


public class AutowiredAnnotationBeanPostProcessor implements BeanPostProcessor{

    ApplicationContext beanContainer;

    public void postProcess(ApplicationContext beanContainer) {

     // objPool?�� 보�??�� 객체 목록?�� 꺼낸?��.
        Collection<Object> objList = beanContainer.objPool.values();
        
        for (Object obj : objList) {
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method m : methods) {
                if (!m.isAnnotationPresent(Autowired.class)) continue;
                
                // setter 메서?��?�� ?��?��미터 ???��?�� ?��?��?��?��.
                Class<?> paramType = m.getParameterTypes()[0];
                
                // �? ?��?��미터 ???���? ?��치하?�� 객체�? objPool?��?�� 꺼낸?��.
                Object dependency = beanContainer.getBean(paramType);
                
                if (dependency == null) continue;
                
                try {
                    m.invoke(obj, dependency);
                    System.out.printf("%s() ?��출됨\n", m.getName());
                } catch (Exception e) {}
            }
        }
    }
    
}
