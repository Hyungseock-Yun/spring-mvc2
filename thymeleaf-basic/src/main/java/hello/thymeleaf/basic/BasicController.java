package hello.thymeleaf.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic")
public class BasicController {

  @GetMapping("text-basic")
  public String textBasic(Model model) {
    model.addAttribute("data", "Hello <b>Spring!</b>");   // HTML 엔티티를 사용하기 때문에 escape 문자로 변환된다.

    return "basic/text-basic";
  }

  @GetMapping("text-unescaped")
  public String textUnescaped(Model model) {
    model.addAttribute("data", "Hello <b>Spring!</b>");

    return "basic/text-unescaped";
  }
}
