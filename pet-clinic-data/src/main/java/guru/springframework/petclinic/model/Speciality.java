package guru.springframework.petclinic.model;

/**
 * Created by piyush.b.kumar on Nov 7, 2018
 */
public class Speciality extends BaseEntity {

	private static final long serialVersionUID = 7571062752033091723L;

	public String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
