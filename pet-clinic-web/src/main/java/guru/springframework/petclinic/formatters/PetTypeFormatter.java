package guru.springframework.petclinic.formatters;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import guru.springframework.petclinic.model.PetType;
import guru.springframework.petclinic.services.PetTypeService;

/**
 * Created by piyush.b.kumar on Nov 20, 2018
 */
@Component
public class PetTypeFormatter implements Formatter<PetType> {

	private final PetTypeService petTypeService;

	public PetTypeFormatter(PetTypeService petTypeService) {
		this.petTypeService = petTypeService;
	}

	@Override
	public String print(PetType petType, Locale locale) {
		return petType.getName();
	}

	@Override
	public PetType parse(String text, Locale locale) throws ParseException {
		Collection<PetType> findPetTypes = petTypeService.findAll();
		for (PetType petType : findPetTypes) {
			if (petType.getName().equals(text)) {
				return petType;
			}
		}
		throw new ParseException("type not found " + text, 0);
	}

}
