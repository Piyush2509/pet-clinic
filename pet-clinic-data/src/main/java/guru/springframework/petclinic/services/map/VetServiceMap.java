package guru.springframework.petclinic.services.map;

import java.util.Set;

import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.CrudService;

/**
 * Created by piyush.b.kumar on Nov 5, 2018
 */
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements CrudService<Vet, Long> {

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		return null;
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

}
