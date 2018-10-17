package ex01;

import java.sql.Date;

public class CarFactory1 {
    public static Car create(String model) {
        Car c = new Car();
        switch(model) {
        case "티코":
            c.setModel("Tico");
            c.setCc(800);
            c.setMaker("대우자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));// 자바 버추얼 머신 -> System
            break;

        case "소나타":
            c.setModel("Sonata");
            c.setCc(1980);
            c.setMaker("현대자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));// 자바 버추얼 머신 -> System
            break;

        case "그랜져":
            c.setModel("grandeur");
            c.setCc(2000);
            c.setMaker("현대자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));
            break;

        default:
            c.setModel("Avante");
            c.setCc(1500);
            c.setMaker("현대자동차");
            c.setCreatedDate(new Date(System.currentTimeMillis()));

        }
        return c;
    }
}
