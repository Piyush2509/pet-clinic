package guru.springframework.petclinic.model;

import java.util.Set;

/**
 * Created by piyush.b.kumar on Nov 1, 2018
 */
public class Owner extends Person {

	private static final long serialVersionUID = -6168114871598177503L;

	private Set<Pet> pets;

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
