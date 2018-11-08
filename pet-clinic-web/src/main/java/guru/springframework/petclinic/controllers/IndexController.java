package guru.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by piyush.b.kumar on Nov 5, 2018
 */
@Controller
public class IndexController {

	@RequestMapping({ "", "/", "index", "index.html" })
	public String index() {
		return "index";
	}

	@RequestMapping("/oups")
	public String oupsHandler() {
		return "notimplemented";
	}

}
