package ex02;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

// @ControllerAdvice가 붙은 클래스는
// 프론트 컨트롤러가 request handler를 호출할 때 마다
// 매번 조언을 얻기 위해 애노테이션 역활에 따라 메서드를 실행한다

@ControllerAdvice
public class GlobalControllerAdvice {
    
    // @InitBinder 조언
    // -> request handler를 호출할 때 그 파라미터 값을 준비해야 하는데,
    //    그 값을 준비하는데 도움이 되는 메서드니까 먼저 이 메서드를 호출하라는 의미다!
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("GlobalControllerAdvice.initBinder()");
             
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        format.setLenient(false); //12시간 표기법(false일 시)
                
        binder.registerCustomEditor(Date.class         
                ,new CustomDateEditor(format, true));
        
        binder.registerCustomEditor(Car.class
                 ,new CarPropertyEditor());
         
    }

}
