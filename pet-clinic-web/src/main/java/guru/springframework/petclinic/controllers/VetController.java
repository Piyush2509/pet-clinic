package guru.springframework.petclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.VetService;

/**
 * Created by piyush.b.kumar on Nov 5, 2018
 */
@Controller
public class VetController {

	private final VetService vetService;

	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@GetMapping({ "/vets", "/vets/index", "/vets/index.html", "/vets.html" })
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}

	@GetMapping("/api/vets")
	public @ResponseBody Set<Vet> getVersJson() {
		return vetService.findAll();
	}

}
