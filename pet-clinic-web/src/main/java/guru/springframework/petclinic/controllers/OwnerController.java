package guru.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by piyush.b.kumar on Nov 5, 2018
 */
@RequestMapping("/owners")
@Controller
public class OwnerController {

	@RequestMapping({ "", "/index", "/index.html" })
	public String listOwners() {
		return "owners/index";
	}

}
