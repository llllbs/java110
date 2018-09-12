package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerdetailController {

    ManagerDao managerDao;
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 이메일은? ");
        String email = keyIn.nextLine();

        Manager manager = managerDao.findByEmil(email);

        System.out.printf("이름: %s\n",manager.getName());
        System.out.printf("이메일: %s\n", manager.getEmail());
        System.out.printf("암호: %s\n", manager.getPassword());
        System.out.printf("전화: %s\n", manager.getTel());
        System.out.printf("재적여부: %s\n", manager.getPosition());
        //boolean이라서 %b사용

    }

}
