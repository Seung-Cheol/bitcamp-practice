package bitcamp.myapp.controller;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import java.sql.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssignmentController {

  private AssignmentDao assignmentDao;

  public AssignmentController(AssignmentDao assignmentDao) {
    System.out.println("AssignmentController 생성됨");
    this.assignmentDao = assignmentDao;
  }

  @RequestMapping("/assignment/form")
  public String form() throws Exception {
    return "/assignment/form.jsp";
  }

  @RequestMapping("/assignment/add")
  public String add(Assignment assignment) throws Exception {
    assignmentDao.add(assignment);
    return "redirect:list";
  }

  @RequestMapping("/assignment/list")
  public String list(Map<String, Object> map) throws Exception {
    map.put("list", assignmentDao.findAll());
    return "/assignment/list.jsp";
  }

  @RequestMapping("/assignment/view")
  public String view(@RequestParam("no") int no, HttpServletRequest request) throws Exception {
    Assignment assignment = assignmentDao.findBy(no);
    if (assignment == null) {
      throw new Exception("과제 번호가 유효하지 않습니다.");
    }
    request.setAttribute("assignment", assignment);
    return "/assignment/view.jsp";
  }

  @RequestMapping("/assignment/update")
  public String update(@RequestParam("no") int no, HttpServletRequest request) throws Exception {

    Assignment old = assignmentDao.findBy(no);
    if (old == null) {
      throw new Exception("과제 번호가 유효하지 않습니다.");
    }

    Assignment assignment = new Assignment();
    assignment.setNo(old.getNo());
    assignment.setTitle(request.getParameter("title"));
    assignment.setContent(request.getParameter("content"));
    assignment.setDeadline(Date.valueOf(request.getParameter("deadline")));

    assignmentDao.update(assignment);
    return "redirect:list";
  }

  @RequestMapping("/assignment/delete")
  public String delete(@RequestParam("no") int no, HttpServletRequest request) throws Exception {
    if (assignmentDao.delete(no) == 0) {
      throw new Exception("과제 번호가 유효하지 않습니다.");
    }
    return "redirect:list";
  }
}
