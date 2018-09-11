package bitcamp.java110.cms.context;

import java.lang.reflect.Method;
import java.util.Collection;

import bitcamp.java110.cms.annotation.Autowired;


public class AutowiredAnnotationBeanPostProcessor implements BeanPostProcessor{

    ApplicationContext beanContainer;

    public void postProcess(ApplicationContext beanContainer) {

     // objPool? λ³΄κ?? κ°μ²΄ λͺ©λ‘? κΊΌλΈ?€.
        Collection<Object> objList = beanContainer.objPool.values();
        
        for (Object obj : objList) {
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method m : methods) {
                if (!m.isAnnotationPresent(Autowired.class)) continue;
                
                // setter λ©μ?? ??Όλ―Έν° ???? ???Έ?€.
                Class<?> paramType = m.getParameterTypes()[0];
                
                // κ·? ??Όλ―Έν° ???κ³? ?ΌμΉν? κ°μ²΄κ°? objPool?? κΊΌλΈ?€.
                Object dependency = beanContainer.getBean(paramType);
                
                if (dependency == null) continue;
                
                try {
                    m.invoke(obj, dependency);
                    System.out.printf("%s() ?ΈμΆλ¨\n", m.getName());
                } catch (Exception e) {}
            }
        }
    }
    
}
