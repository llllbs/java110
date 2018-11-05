package ex07;

import java.beans.PropertyEditorSupport;

//String -> ex07.Engine 프로퍼티 값 변환기
public class EnginePropertyEditor extends PropertyEditorSupport {

    public EnginePropertyEditor() {
        System.out.println("enginePropertyEditor() 호출됨!");
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("enginePropertyEditor.setAsText(String)");

        String[] engine1 = text.split(",");
        // split으로 잘라내서 -> 배열에 집어 넣기

        Engine engine = new Engine(engine1[0], Integer.parseInt(engine1[1]), Boolean.parseBoolean(engine1[2]));
        // valueof 와 같은 의미

        this.setValue(engine);

    }
}
