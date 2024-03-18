package bitcamp.app1;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalInitBinder {
  @InitBinder
  public void ok(WebDataBinder 데이터변환등록기) {
    //String값을 해당 타입으로 변환해줄 변환기
    데이터변환등록기.registerCustomEditor(
      java.sql.Date.class,
      new DatePropertyEditor());

    데이터변환등록기.registerCustomEditor(
      Car.class, //String 값을 Car 객체로 만들 것이라고 지정
      new CarPropertyEditor()
    );
    데이터변환등록기.registerCustomEditor(
      Engine.class,
      new EnginePropertyEditor()
    );
  }

}
