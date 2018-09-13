package bitcamp.java110.cms.domain;

import java.io.Serializable;

public class Member implements Serializable{
    private static final long serialVersionUID = 1L;
    // 상위 클래스에 Serializable implements를 하면 하위 클래스에서 안해도 됨
    

    protected int no;
    protected String name;
    protected String email;
    protected String password;
    // transient protected String password; 
    // transient는 Serialize대상에서 제외된다

    // 인스턴스의 메모리를 다루는 operator = setter/getter = accessor = property = message
    
    
    public String getName() {
        return name;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}


