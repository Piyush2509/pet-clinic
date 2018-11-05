package guru.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by piyush.b.kumar on Nov 5, 2018
 */
@Controller
public class VetController {

	@RequestMapping({ "/vets", "/vets/index", "/vets/index.html" })
	public String listVets() {
		return "vets/index";
	}

}
