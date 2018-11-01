package guru.springframework.petclinic.model;

import java.io.Serializable;

/**
 * Created by piyush.b.kumar on Nov 1, 2018
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -6852319477180547150L;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
