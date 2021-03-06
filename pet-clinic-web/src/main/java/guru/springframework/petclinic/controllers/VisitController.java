package guru.springframework.petclinic.controllers;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import guru.springframework.petclinic.model.Pet;
import guru.springframework.petclinic.model.Visit;
import guru.springframework.petclinic.services.PetService;
import guru.springframework.petclinic.services.VisitService;

/**
 * Created by piyush.b.kumar on Nov 20, 2018
 */
@Controller
public class VisitController {

	private static final String VIEWS_VISITS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdateVisitForm";
	private final VisitService visitService;
	private final PetService petService;

	public VisitController(VisitService visitService, PetService petService) {
		this.visitService = visitService;
		this.petService = petService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");

		dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(LocalDate.parse(text));
			}
		});
	}

	@ModelAttribute("visit")
	public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Model model) {
		Pet pet = petService.findById(petId);
		model.addAttribute("pet", pet);
		Visit visit = Visit.builder().build();
		pet.getVisits().add(visit);
		visit.setPet(pet);
		return visit;
	}

	@GetMapping("/owners/*/pets/{petId}/visits/new")
	public String initNewVisitForm(@PathVariable("petId") Long petId, Model model) {
		return VIEWS_VISITS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
	public String processNewVisitForm(@Valid Visit visit,
			/* @PathVariable("ownerId") Long ownerId, */ BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_VISITS_CREATE_OR_UPDATE_FORM;
		} else {
			visitService.save(visit);
			return "redirect:/owners/{ownerId}";
		}
	}

}
