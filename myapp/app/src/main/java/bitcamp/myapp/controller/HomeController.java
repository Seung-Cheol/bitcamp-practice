package bitcamp.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

  public HomeController() {
    System.out.println("HomeController() 호출됨!");
  }

  @GetMapping("")
  public void home() {
  }
}
