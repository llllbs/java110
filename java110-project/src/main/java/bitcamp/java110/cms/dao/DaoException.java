package bitcamp.java110.cms.dao;

public class DaoException extends Exception{

    private static final long serialVersionUID = 1L;

    public DaoException() {
        super();
        // super클래스 생성 전에 어떤 것도 사용할 수 없음
    }

    public DaoException(String message, Throwable cause) {
        // 왜 에러났는지, 무슨 이유인지 상세 표시
        super(message, cause);
//        super(message, cause);를 없애면 기본 생성자 호출
    }

    public DaoException(String message) {
        super(message); 
    }
    
    

}
