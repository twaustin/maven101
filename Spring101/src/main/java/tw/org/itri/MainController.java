package tw.org.itri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
	@RequestMapping(value="/")
	public String sayHello() {
		return "Hello Spring boot";
	}	
}
