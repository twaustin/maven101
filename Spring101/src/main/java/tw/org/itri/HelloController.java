package tw.org.itri;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		return new ModelAndView("hello"); // 根據view resolver mapping至hello.jsp
	}
}

