package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerJdbcDao implements ManagerDao {

    public int insert(Manager manager) {
        Connection con = null;
        Statement stmt = null;

        try {
            
            
            Class.forName("org.mariadb.jdbc.Driver");


            con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
            
            // 매니저 정보를 입력할 때 p1_memb 테이블과 p1_mgr 테이블에 매니저 정보를 분산 입력해야 한다
            // 두 테이블에 모두 입력 성공 할 때 입력을 완료하도록, 두 insert를 한 작업(transaction)으로 묶는다
           //-> SQL을 서버에 보낸 후 클라이언트가 최종 완료 신호를 보내기 전까지는 처리를 보류하도록 설정한다
            con.setAutoCommit(false);
            
            stmt = con.createStatement();
            String sql = ("insert into p1_memb(name,email, pwd, tel, cdt)"
                    +" value('"+manager.getName()
                    + "','"+manager.getEmail()
                    + "',password('"+manager.getPassword()
                    + "'),'"+manager.getTel()
                    + "',now())");
            
            // p1_memb 테이블에 회원 기본 정보를 입력 한 후 자동으로 생성된 회원 번호를 리턴 받는다.
            
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            // insert를 실행 한 후 리턴 받은 자동증가 PK값을 꺼내기
            // resultSet은 자동증가된 값을 꺼내는 용도로 사용
            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int memberNo = autogeneratedKeys.getInt(1);
            // resultset은 첫번째 컬럼 번호가 1부터 시작
            autogeneratedKeys.close();
            
            // 회원 번호로 매니저 테이블에 직위 정보를 입력한다
            String sql2 = "insert into p1_mgr(mrno,posi) "
                    + "values("+memberNo
                    + ",'"+manager.getPosition()
                    + "')";
            
            stmt.executeUpdate(sql2);
            
            // 두 insert가 모두 성공했을 때만 서버에 완료 신호를 보낸다.
            con.commit();
            return 1;
        }catch(Exception e) {

            throw new DaoException(e);
        }finally {

            try{stmt.close();} catch(Exception e) {}
            try{con.close();} catch(Exception e) {}
        }
        
    }



    public List<Manager> findAll(){

        ArrayList<Manager> list = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //-> java.sql.Driver 구현체를 로딩한다
            //-> 해당 클래스의 객체를 만들어 DriverManager에 등록한다

            Class.forName("org.mariadb.jdbc.Driver");

            //-> DriverManager에게 Connection 객체를 요구한다
            //-> DriverManager는 등록된 Driver 들 중에서 요구사항에 맞는 드라이버를 찾아 connect()를 호출
            //-> 그리고 connect() 메서드의 리턴 값을 그대로 리턴해 준다
            con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
            //            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
            // -> 질의문을 작성할 객체를 준비한다
            stmt = con.createStatement();

            // -> select 질의를 한다
            /*
              select m.name, m.email, mr.posi
              from p1_mgr mr inner join p1_memb m 
              on mr.mrno = m.mno;
             */
            rs = stmt.executeQuery(
                    "select "
                            + "m.mno,"
                            + "m.name,"
                            + "m.email,"
                            + "mr.posi" + 
                            " from p1_mgr mr inner join p1_memb m" + 
                    " on mr.mrno = m.mno;");
            // 서버에 생성된 질의 결과를 한 개씩 가져온다.
            while(rs.next()) {
                Manager mgr = new Manager(); // 새 데이터를 저장하려면 새 그릇에
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setPosition(rs.getString("posi"));

                list.add(mgr);

            }


        }catch(Exception e) {

            throw new DaoException(e);
        }finally {
            try{rs.close();} catch(Exception e) {}
            try{stmt.close();} catch(Exception e) {}
            try{con.close();} catch(Exception e) {}
        }
        return list;

    }

    public Manager findByEmil(String email) {
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            
            Class.forName("org.mariadb.jdbc.Driver");

           
            con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select "
                            + "m.mno,"
                            + " m.name,"
                            + " m.email,"
                            + " m.tel,"
                            + " mr.posi" 
                            + " from p1_mgr mr inner join p1_memb m" 
                            + " on mr.mrno = m.mno"
                            + " where m.email='" +email+"'");
            
            if(rs.next()){
                Manager mgr = new Manager(); // 새 데이터를 저장하려면 새 그릇에
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setName(rs.getString("tel"));
                mgr.setPosition(rs.getString("posi"));
                
                return mgr;

            }
            return null;


        }catch(Exception e) {

            throw new DaoException(e);
        }finally {
            try{rs.close();} catch(Exception e) {}
            try{stmt.close();} catch(Exception e) {}
            try{con.close();} catch(Exception e) {}
        }
        

        
    }
    
public Manager findByNo(int no) {
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            
            Class.forName("org.mariadb.jdbc.Driver");

           
            con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select "
                            + "m.mno,"
                            + " m.name,"
                            + " m.email,"
                            + " m.tel,"
                            + " mr.posi" 
                            + " from p1_mgr mr inner join p1_memb m" 
                            + " on mr.mrno = m.mno"
                            + " where m.mno=" + no);
            
            if(rs.next()){
                Manager mgr = new Manager(); // 새 데이터를 저장하려면 새 그릇에
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setName(rs.getString("tel"));
                mgr.setPosition(rs.getString("posi"));
                
                return mgr;

            }
            return null;


        }catch(Exception e) {

            throw new DaoException(e);
        }finally {
            try{rs.close();} catch(Exception e) {}
            try{stmt.close();} catch(Exception e) {}
            try{con.close();} catch(Exception e) {}
        }
        

        
    }

    public int delete(String email) {
        return 0;

}
    public int deleteByNo(int no) {
        
        Connection con = null;
        Statement stmt = null;

        try {
            
            
            Class.forName("org.mariadb.jdbc.Driver");

            con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
           
            con.setAutoCommit(false);
            stmt = con.createStatement();
            
            String sql = "delete from p1_mgr where mrno=" +no;
            int count = stmt.executeUpdate(sql);
            
            if(count == 0)
                return 0;
            
            String sql2 = "delete from p1_mgr where mrno=" +no;
            stmt.executeUpdate(sql2);
            
            con.commit();
            return 1;
            
        }catch(Exception e) {

            throw new DaoException(e);
        }finally {

            try{stmt.close();} catch(Exception e) {}
            try{con.close();} catch(Exception e) {}
        }
    }

}// end class
