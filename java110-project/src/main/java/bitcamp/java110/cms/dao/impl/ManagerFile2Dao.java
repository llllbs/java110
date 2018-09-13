package bitcamp.java110.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DuplicationDaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MandatoryValueDaoException;
import bitcamp.java110.cms.domain.Manager;

//@Component
public class ManagerFile2Dao implements ManagerDao {

    static String defaultFilename = "data/manager2.dat";
    // 모든 클래스가 동일한 값
    String filename;
    // 바뀌는 값

    private List<Manager> list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public ManagerFile2Dao(String filename) {
        this.filename = filename;

        File dataFile = new File(filename);

        try(
                FileInputStream in0 = new FileInputStream(dataFile);
                BufferedInputStream in1 = new BufferedInputStream(in0);
                ObjectInputStream in = new ObjectInputStream(in1);

                ){
            list = (List<Manager>)in.readObject();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    public ManagerFile2Dao() {
        this(defaultFilename);
        // 중복된 생성자는 this로 받아온다(맨 처음자리)
    }

    private void save() {

        File dataFile = new File(filename);

        try(
                FileOutputStream out0 = new FileOutputStream(dataFile);
                BufferedOutputStream out1 = new BufferedOutputStream(out0);
                ObjectOutputStream out = new ObjectOutputStream(out1);
                // Decorator: 기능을 붙혔다 뗐다 하면서 사용

                ){
            out.writeObject(list);

        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    public int insert(Manager manager) throws MandatoryValueDaoException, DuplicationDaoException  {
        // 필수 항목이 비었을 때,
        if(manager.getName().length() == 0||
                manager.getEmail().length() ==0||
                manager.getPassword().length() ==0) {

            //호출자에게 예외 정보를 만들어 던진다
            throw new MandatoryValueDaoException();
        }

        for(Manager item : list) {
            if(item.getEmail().equals(manager.getEmail())) {
                // 같은 이메일의 매니저가 있을경우
                // 예외처리 문법이 없던 시절에는 리턴 값으로 예외 상황을 호출자에게 알렸다

                //호출자에게 예외 정보를 만들어 던진다
                throw new DuplicationDaoException();
            }
        }

        list.add(manager);
        save();
        return 1;

    }

    public List<Manager> findAll() {
        return list;

    }

    public Manager findByEmil(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;

    }

    public int delete(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        return 0;

    }

}// end class
