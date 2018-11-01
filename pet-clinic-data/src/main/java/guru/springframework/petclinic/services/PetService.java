package guru.springframework.petclinic.services;

import java.util.Set;

import guru.springframework.petclinic.model.Pet;

/**
 * Created by piyush.b.kumar on Nov 1, 2018
 */
public interface PetService {

	Pet findById(Long id);

	Pet save(Pet pet);

	Set<Pet> findAll();

}
