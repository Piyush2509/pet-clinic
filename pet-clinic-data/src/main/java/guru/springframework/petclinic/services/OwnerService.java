package guru.springframework.petclinic.services;

import java.util.Set;

import guru.springframework.petclinic.model.Owner;

/**
 * Created by piyush.b.kumar on Nov 1, 2018
 */
public interface OwnerService {

	Owner findByLastName(String lastName);

	Owner findById(Long id);

	Owner save(Owner owner);

	Set<Owner> findAll();

}
