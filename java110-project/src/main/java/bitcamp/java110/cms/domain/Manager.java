package bitcamp.java110.cms.domain;

public class Manager extends Member{
    
  
    private static final long serialVersionUID = 1L;
    protected String tel;
    protected String position;

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

}
