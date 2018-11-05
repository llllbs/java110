// 인스턴스 비교 I : equals() overriding 전
// 
package ex05;

public class Test02_p1 {
<<<<<<< HEAD
    
    static class Member{
        // 기본 클래스는 전부 extends Object
=======

    static class Member {
>>>>>>> 75477e84ac13cc88961bc05a5529250a90231bbe
        String name;
        int age;
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    
    public static void main(String[] args) {
        
        Member obj1 = new Member("홍길동", 20);
        Member obj2 = new Member("홍길동", 20);
        
        // 인스턴스 비교
        // 1) == 연산자는 레퍼런스에 저장된 인스턴스의 주소를 비교한다.
        if (obj1 == obj2) System.out.println("obj1 == obj2");
        else System.out.println("obj1 != obj2");
        
        // 2) Object에서 상속 받은 equals() 메서드는 == 연산자와 같다.
        if (obj1.equals(obj2)) System.out.println("obj1 == obj2");
        else System.out.println("obj1 != obj2");
        
<<<<<<< HEAD
        // Object에서 상속 받은 equals()메서드는 == 연산자와 같다.
        if(obj1.equals(obj2))
            System.out.println("obj1 == obj2");
        else
            System.out.println("obj1 != obj2");
        // String 일 경우는 값이 같을 시 equals 는 true
        // 하지만 object는 해시값과 주소값은 override하지 않기 때문에 false
  
=======
>>>>>>> 75477e84ac13cc88961bc05a5529250a90231bbe
    }

}









