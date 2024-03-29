package bitcamp.myapp.controller;

import bitcamp.myapp.service.MemberService;
import bitcamp.myapp.service.StorageService;
import bitcamp.myapp.vo.Member;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController implements InitializingBean {

  private static final Log log = LogFactory.getLog(MemberController.class);
  private final MemberService memberService;
  private final StorageService storageService;
  private String uploadDir;

  @Value("${ncp.ss.bucketname}")
  private String bucketName;

  @Override
  public void afterPropertiesSet() throws Exception {
    log.debug(String.format("bucketName : %s", this.bucketName));
    log.debug(String.format("uploadDir : %s", this.uploadDir));
    this.uploadDir = "member/";
  }

  @GetMapping("form")
  public void form() throws Exception {
  }

  @PostMapping("add")
  public String add(Member member, MultipartFile file) throws Exception {
    if (file.getSize() > 0) {
      String filename = storageService.upload(bucketName, uploadDir, file);
      member.setPhoto(filename);
    }
    memberService.add(member);
    return "redirect:list";
  }

  @GetMapping("list")
  public void list(
    Model model,
    @RequestParam(defaultValue = "5") int pageSize,
    @RequestParam(defaultValue = "1") int pageNo) throws Exception {
    int totalCount = memberService.countAll();
    int totalPage = totalCount / pageSize + (totalCount % pageSize != 0 ? 1 : 0);
    model.addAttribute("list", memberService.list(pageSize, pageNo));
    model.addAttribute("totalPage", totalPage);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("pageNo", pageNo);
  }

  @GetMapping("view")
  public void view(int no, Model model) throws Exception {
    Member member = memberService.get(no);
    if (member == null) {
      throw new Exception("회원 번호가 유효하지 않습니다.");
    }
    model.addAttribute("member", member);
  }

  @PostMapping("update")
  public String update(Member member, MultipartFile file) throws Exception {

    Member old = memberService.get(member.getNo());
    if (old == null) {
      throw new Exception("회원 번호가 유효하지 않습니다.");
    }
    member.setCreatedDate(old.getCreatedDate());

    if (file.getSize() > 0) {
      storageService.delete(this.bucketName, this.uploadDir, old.getPhoto());
      String filename = storageService.upload(bucketName, uploadDir, file);
      member.setPhoto(filename);
    } else {
      member.setPhoto(old.getPhoto());
    }

    memberService.update(member);
    return "redirect:list";
  }

  @GetMapping("delete")
  public String delete(int no) throws Exception {
    Member member = memberService.get(no);
    if (member == null) {
      throw new Exception("회원 번호가 유효하지 않습니다.");
    }

    memberService.delete(no);

    String filename = member.getPhoto();
    if (filename != null) {
      storageService.delete(this.bucketName, this.uploadDir, member.getPhoto());
    }
    return "redirect:list";
  }
}
