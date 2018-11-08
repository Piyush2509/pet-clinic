package guru.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.petclinic.model.PetType;

/**
 * Created by piyush.b.kumar on Nov 8, 2018
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
