// @RequestMapping 다루기: URL 다루기2
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test09")
public class Test09 {
    
    // 공통 URL은 클래스에 선언한다
    // 위의 @RequestMapping("/ex02/test08")와 합쳐서 /ex02/test08/m1으로 나타내줌
    
    @RequestMapping("m1")
    @ResponseBody
    public String m1() {
        return "ex02.Test09.m1()";
    }
    
    @RequestMapping("m2")
    @ResponseBody
    public String m2() {
        return "ex02.Test09.m2()";
    }
    
}
