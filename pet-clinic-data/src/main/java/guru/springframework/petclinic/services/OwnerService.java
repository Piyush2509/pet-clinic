package guru.springframework.petclinic.services;

import java.util.List;

import guru.springframework.petclinic.model.Owner;

/**
 * Created by piyush.b.kumar on Nov 1, 2018
 */
public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

	List<Owner> findAllByLastNameLike(String lastName);

}
