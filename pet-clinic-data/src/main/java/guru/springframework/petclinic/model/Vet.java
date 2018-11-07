package guru.springframework.petclinic.model;

import java.util.Set;

/**
 * Created by piyush.b.kumar on Nov 1, 2018
 */
public class Vet extends Person {

	private static final long serialVersionUID = -4510798593311391277L;

	private Set<Speciality> specialities;

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}

}
