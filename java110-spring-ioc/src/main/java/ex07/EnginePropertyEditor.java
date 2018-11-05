package ex07;

import java.beans.PropertyEditorSupport;

// String ==> ex07.Engine 프로퍼티 값 변환기
//
public class EnginePropertyEditor extends PropertyEditorSupport {

    public EnginePropertyEditor() {
        System.out.println("EnginePropertyEditor() 호출됨!");
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
<<<<<<< HEAD
        System.out.println("enginePropertyEditor.setAsText(String)");

        String[] engine1 = text.split(",");
        // split으로 잘라내서 -> 배열에 집어 넣기

        Engine engine = new Engine(engine1[0], Integer.parseInt(engine1[1]), Boolean.parseBoolean(engine1[2]));
        // valueof 와 같은 의미

        this.setValue(engine);

=======
        System.out.println("EnginePropertyEditor.setAsText(String)");
        
        String[] values = text.split(",");
        Engine engine = new Engine();
        engine.setMaker(values[0]);
        engine.setValve(Integer.parseInt(values[1]));
        engine.setDiesel(Boolean.parseBoolean(values[2]));
        
        this.setValue(engine);
    }
    
    @Override
    public Object getValue() {
        System.out.println("EnginePropertyEditor.getValue()");
        return super.getValue();
>>>>>>> 75477e84ac13cc88961bc05a5529250a90231bbe
    }
}










