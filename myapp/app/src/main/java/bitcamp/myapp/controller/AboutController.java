package bitcamp.myapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

  @RequestMapping("/about")
  public String execute()
    throws Exception {
    return "/about.jsp";
  }
}