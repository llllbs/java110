package bitcamp.java110.cms.server;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;


public class Request {
    String command;
    String appPath;
    String queryString;
    Map<String,String> paramMap = new HashMap<>();

    public Request(String command) {
        this.command = command;

        // 명령어에서 Query String을 분리한다
        //ex) manager/add?name=aaa&email=aaa@test.com&password=1111 no=10
        String[] values = command.split("\\?");// 자바 문법 때문에 \\를 사용 (원래는 1개)
        this.appPath = values[0];// ?를 기준으로 앞부분은 appPath ex)manager/add
        if(values.length >= 2) {//?를 기준으로 뒷부분은 queryString ex) name=aaa&email=aaa@test.com&password=1111 no=10
            queryString = values[1];
            
            parseQueryString(queryString);
        }

    }

    private void parseQueryString(String qs) {
        String[] values = qs.split("&");
        for(String value:values) {
            String[] kv = value.split("=");
            paramMap.put(kv[0], kv[1]);
            
                    
            
        }
        
    }
    
    public String getParameter(String name) {
        return this.paramMap.get(name);
    }

    public String getCommand() {
        return this.command;
    }

    public String getAppPath() {
        return this.appPath;
    }

    public String getQueryString () {
        return this.queryString;
    }
    public static void main(String[]args) {
        String str = "manager/add?name=aaa&email=aaa@test.com&password=1111";
        
        Request req = new Request(str);
        
   
        
    }
}


