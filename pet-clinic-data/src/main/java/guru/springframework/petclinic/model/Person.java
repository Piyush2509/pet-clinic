package guru.springframework.petclinic.model;

/**
 * Created by piyush.b.kumar on Nov 1, 2018
 */
public class Person extends BaseEntity {

	private static final long serialVersionUID = -5249873716072541540L;

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
