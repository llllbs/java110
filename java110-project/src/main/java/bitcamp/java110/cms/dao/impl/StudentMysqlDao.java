package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.util.DataSource;

public class StudentMysqlDao implements StudentDao {

    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int insert(Student student) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            
            con.setAutoCommit(false);

            stmt = con.createStatement();
            String sql = "insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values('" + student.getName()
                    + "','" + student.getEmail()
                    + "',password('" + student.getPassword()
                    + "'),'" + student.getTel()
                    + "',now())";
            
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int memberNo = autogeneratedKeys.getInt(1);
            autogeneratedKeys.close();
            
            String sql2 = "insert into p1_stud(sno,schl,work)"
                    + " values(" + memberNo
                    + ",'" + student.getSchool()
                    + "','" + (student.isWorking()?'Y':'N')
                    + "')";
            stmt.executeUpdate(sql2);
            
            if(student.getPhoto() != null) {

                String sql3 = "insert into p1_memb_phot(mno,photo)"
                        +"values("+memberNo
                        +", '"+student.getPhoto()
                        +"')";
                stmt.executeUpdate(sql3);

            }
            
            con.commit();
            return 1;
            
        } catch (Exception e) {
            try {con.rollback();} catch (Exception e2) {}
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
        }
    }
    
    public List<Student> findAll() throws DaoException {
        
        ArrayList<Student> list = new ArrayList<>();
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " s.schl," +
                    " s.work" +
                    " from p1_stud s" + 
                    " inner join p1_memb m on s.sno = m.mno");
            
            while (rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setEmail(rs.getString("email"));
                s.setName(rs.getString("name"));
                s.setSchool(rs.getString("schl"));
                s.setWorking(rs.getString("work").equals("Y") ? true : false);
                
                list.add(s);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
        return list;
    }
    
    public Student findByEmail(String email) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " s.schl," +
                    " s.work," + 
                    " mp.photo" + 
                    " from p1_stud s" + 
                    " inner join p1_memb m on s.sno = m.mno" +
                    " left outer join p1_memb_phot mp on s.sno = mp.mno" +
                    " where m.email='" + email + "'");
            
            if (rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setEmail(rs.getString("email"));
                s.setName(rs.getString("name"));
                s.setTel(rs.getString("tel"));
                s.setSchool(rs.getString("schl"));
                s.setWorking(rs.getString("work").equals("Y") ? true : false);
                s.setPhoto(rs.getString("photo"));
                
                return s;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
    }
    
    public Student findByNo(int no) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " s.schl," +
                    " s.work," +  
                    " mp.photo" + 
                    " from p1_stud s" + 
                    " inner join p1_memb m on s.sno = m.mno" +
                    " left outer join p1_memb_phot mp on s.sno = mp.mno" +
                    " where s.sno=" + no);
            
            if (rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setEmail(rs.getString("email"));
                s.setName(rs.getString("name"));
                s.setTel(rs.getString("tel"));
                s.setSchool(rs.getString("schl"));
                s.setWorking(rs.getString("work").equals("Y") ? true : false);
                s.setPhoto(rs.getString("photo"));
                
                return s;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
    }
    
    public int delete(int no) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            
            con.setAutoCommit(false);
            stmt = con.createStatement();
            
            String sql = "delete from p1_stud where sno=" + no ;
            int count = stmt.executeUpdate(sql);
            
            if (count == 0)
                throw new Exception("일치하는 번호가 없습니다.");
            
            sql = "delete from p1_memb_phot where mno=" + no;
            stmt.executeUpdate(sql);
            
            String sql2 = "delete from p1_memb where mno=" + no;
            stmt.executeUpdate(sql2);
            con.commit();
            
            return 1;
            
        } catch (Exception e) {
            try {con.rollback();} catch (Exception e2) {}
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
        }
    }
    
    @Override
    public Student findByEmailPassword(String email, String password) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " m.tel," + 
                    " s.schl," +
                    " s.work" + 
                    " from p1_stud s" + 
                    " inner join p1_memb m on s.sno = m.mno" +
                    " where m.email='" + email + 
                    "' and m.pwd=password('" + password +
                    "')");
            
            if (rs.next()) {
                Student s = new Student();
                s.setNo(rs.getInt("mno"));
                s.setEmail(rs.getString("email"));
                s.setName(rs.getString("name"));
                s.setTel(rs.getString("tel"));
                s.setSchool(rs.getString("schl"));
                s.setWorking(rs.getString("work").equals("Y") ? true : false);
                
                
                return s;
            }
            return null;
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
    }
}









