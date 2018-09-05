package bitcamp.java110.cms.dao;

import bitcamp.java110.cms.domain.Student;

public class StudentList {

    static Student[] students = new Student[5];

    static int studentIndex = 0;

    

    public static void add(Student student) {

      

            if(studentIndex == students.length) {

                increaseStorage();

            }

            students[studentIndex++] = student;

        }

 

    private static void increaseStorage() {

      //배열 크기 늘리기

        Student[] newList = new Student[students.length+3];

        for(int i=0;i<students.length;i++) {

            newList[i] = students[i];

        }

        students = newList;

    }

    

    public static void remove(int no) {

   

        if(no<0 || no>=studentIndex) {

            return;

        }

 

        for(int i=no;i<=studentIndex-2;i++) {

            students[i] = students[i+1];

        }

        studentIndex--;

        System.out.println("삭제하였습니다.");

    }

    

    public static int size() {

        return studentIndex;

    }

 

    public static Student get(int no) {

        // TODO Auto-generated method stub

        if(no<0 || no>=studentIndex) {

            return null;

        }

        return students[no];

    }

}
