package bitcamp.java110.cms.dao;

import bitcamp.java110.cms.domain.Teacher;

public class TeacherList {

    static int teacherIndex = 0;
    static Teacher[] teachers = new Teacher[100];

    public static void add(Teacher teacher) {

        if(teacherIndex == teachers.length) {
            increaseStorage();

        }

        teachers[teacherIndex++] = teacher;

    }

    private static void increaseStorage() {
        Teacher[] newList = new Teacher[teachers.length +3 ];
        for(int i=0; i<teachers.length; i++) {
            newList[i] = teachers[i];
        }
        teachers = newList;
    }

    public static void remove(int no) {

        if(no < 0 || no >= teacherIndex) {

            return;
        }

        for(int i = no; i<teacherIndex-1; i++) {
            teachers[i] = teachers[i+1];
        }
        teacherIndex --;

        System.out.println("삭제 하였습니다.");

    }

    public static int size() {
        return teacherIndex;
    }

    public static Teacher get(int no) {
        // TODO Auto-generated method stub
        if(no < 0 || no >= teacherIndex) {
            return null;
        }
        return teachers[no];
    }





}//end class
