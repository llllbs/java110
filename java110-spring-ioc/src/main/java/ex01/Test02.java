// 객체 생성하기: Factory method 패턴 적용
package ex01;

public class Test02 {
    public static void main(String[] args) {
        Car c1 = CarFactory1.create("그랜져");// static 메소드라서 클래스.메소드 사용 
        
        System.out.println(c1);
        
    }

}
