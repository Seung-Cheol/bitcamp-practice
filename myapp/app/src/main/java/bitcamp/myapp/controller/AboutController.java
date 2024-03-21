package bitcamp.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

  public AboutController() {
    System.out.println("AboutController() 호출됨!");
  }

  @GetMapping("/about")
  public void about() {
  }
}
