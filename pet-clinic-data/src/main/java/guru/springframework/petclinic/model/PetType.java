package guru.springframework.petclinic.model;

/**
 * Created by piyush.b.kumar on Nov 1, 2018
 */
public class PetType extends BaseEntity {

	private static final long serialVersionUID = -7458773405372253161L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
