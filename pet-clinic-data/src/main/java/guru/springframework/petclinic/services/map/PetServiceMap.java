package guru.springframework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.petclinic.model.Pet;
import guru.springframework.petclinic.services.PetService;

/**
 * Created by piyush.b.kumar on Nov 5, 2018
 */
@Service
public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements PetService {

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}

}
