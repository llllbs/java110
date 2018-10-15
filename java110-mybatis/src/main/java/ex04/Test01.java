//Mybatics - 페이징 처리


package ex04;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

    public static void main(String[] args) throws Exception {
        
        
        String resource = "ex04/mybatis-config-01.xml";
        
        
        InputStream inputStream = Resources.getResourceAsStream(resource);
        
        
        SqlSessionFactory sqlSessionFactory = 
                new SqlSessionFactoryBuilder().build(inputStream);
        
        MemberDao memberDao = new MemberDao();
        memberDao.setSqlSessionFactory(sqlSessionFactory);
        
        // 페이징 처리
        int pageNo = 8;
        int pageSize = 3;
        
        HashMap<String, Object> params = new HashMap<>();
        params.put("rowNo", (pageNo-1)*pageSize);// 시작 레코드 번호
        params.put("pageSize", 3);
   
        List<Member> list = memberDao.findAll(params);
        
        for(Member m : list) {
            System.out.printf("%d, %s, %s, %s\n"
                    ,m.getNo()
                    ,m.getName()
                    ,m.getEmail()
                    ,m.getTel());
        }
        

    }

}
