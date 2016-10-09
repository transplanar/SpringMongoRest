package springMongo;

import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
// @RestController
// public class NavController {
public class HomeController {

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

}
