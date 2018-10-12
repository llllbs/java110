// 디자인패턴 - 팩토리 메소드 
// Mybatics 적용


package ex03;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04 {

    public static void main(String[] args) throws Exception {
        
        // 1)mybatis 설정파일 경로
        String resource = "ex03/mybatis-config.xml";
        
        // 2) 설정 파일을 읽을 InputStream 준비
        // -> 자바 classpath에서 설정 파일을 찾는다
        InputStream inputStream = Resources.getResourceAsStream(resource);
        
        // 3) sqlSession 객체를 생성해 줄 팩토리 객체를 준비
        // -> mybatis 설정 파일에 정의된 대로 객체를 준비한다.
        SqlSessionFactory sqlSessionFactory = 
                new SqlSessionFactoryBuilder().build(inputStream);
        
        MemberDao memberDao = new MemberDao();
        
        // 4)Mybatis 객체를 MemberDao에게 넘겨준다
        memberDao.setSqlSessionFactory(sqlSessionFactory);
        
        Member m = memberDao.findByNo(91);
        
        System.out.println(m.getNo());
        System.out.println(m.getName());
        System.out.println(m.getEmail());
        System.out.println(m.getTel());
        
        

    }

}
