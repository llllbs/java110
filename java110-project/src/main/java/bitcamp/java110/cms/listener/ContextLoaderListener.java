package bitcamp.java110.cms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.dao.impl.MemberMysqlDao;
import bitcamp.java110.cms.dao.impl.PhotoMysqlDao;
import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.dao.impl.TeacherMysqlDao;
import bitcamp.java110.cms.service.impl.AuthServiceimpl;
import bitcamp.java110.cms.service.impl.ManagerServiceimpl;
import bitcamp.java110.cms.service.impl.StudentServiceimpl;
import bitcamp.java110.cms.service.impl.TeacherServiceimpl;
import bitcamp.java110.cms.util.DataSource;

//@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener.contextInitialized() 실행!");
        
        ServletContext sc = sce.getServletContext();

        // DAO가 사용할 DB 커넥션풀 객체 준비
        // => DataSource 객체를 만들 때 컨텍스트 파라미터 값을 꺼내서 사용한다.
        try {
            DataSource dataSource = new DataSource(
                    sc.getInitParameter("jdbc.driver"),
                    sc.getInitParameter("jdbc.url"),
                    sc.getInitParameter("jdbc.username"),
                    sc.getInitParameter("jdbc.password"));
            
            // DAO 객체 생성 및 DB 커네션풀 주입하기
            MemberMysqlDao memberDao = new MemberMysqlDao();
            memberDao.setDataSource(dataSource);
            
            ManagerMysqlDao managerDao = new ManagerMysqlDao();
            managerDao.setDataSource(dataSource);
            
            StudentMysqlDao studentDao = new StudentMysqlDao();
            studentDao.setDataSource(dataSource);
            
            TeacherMysqlDao teacherDao = new TeacherMysqlDao();
            teacherDao.setDataSource(dataSource);
            
            PhotoMysqlDao photoDao = new PhotoMysqlDao();
            photoDao.setDataSource(dataSource);
            
            // 서비스 객체 준비하기
            ManagerServiceimpl managerService = new ManagerServiceimpl();
            managerService.setMemberDao(memberDao);
            managerService.setManagerDao(managerDao);
            managerService.setPhotoDao(photoDao);
            
            // 서블릿에서 서비스를 이용할 수 있도록 ServletContext 보관소에 저장하기
            sc.setAttribute("managerService", managerService);

            // 서비스 객체 준비하기

            StudentServiceimpl studentService = new StudentServiceimpl();
            studentService.setMemberDao(memberDao);
            studentService.setStudentDao(studentDao);
            studentService.setPhotoDao(photoDao);
            
            // 서블릿에서 서비스를 이용할 수 있도록 ServletContext 보관소에 저장하기
            sc.setAttribute("studentService", studentService);

            // 서비스 객체 준비하기
            TeacherServiceimpl teacherService = new TeacherServiceimpl();
            teacherService.setMemberDao(memberDao); 
            teacherService.setTeacherDao(teacherDao);
            teacherService.setPhotoDao(photoDao);
            
            // 서블릿에서 서비스를 이용할 수 있도록 ServletContext 보관소에 저장하기
            sc.setAttribute("teacherService", teacherService);

            // 서비스 객체 준비하기
            AuthServiceimpl authService = new AuthServiceimpl();
            authService.setTeacherDao(teacherDao);
            authService.setStudentDao(studentDao);
            authService.setManagerDao(managerDao);
            
            // 서블릿에서 서비스를 이용할 수 있도록 ServletContext 보관소에 저장하기
            sc.setAttribute("authService", authService);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
