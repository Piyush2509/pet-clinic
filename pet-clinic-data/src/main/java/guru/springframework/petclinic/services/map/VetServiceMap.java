package guru.springframework.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.SpecialityService;
import guru.springframework.petclinic.services.VetService;

/**
 * Created by piyush.b.kumar on Nov 5, 2018
 */
@Service
public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements VetService {

	private final SpecialityService specialityService;

	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

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
		if (object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(speciality -> {
				if (speciality.getId() == null) {
					speciality.setId(specialityService.save(speciality).getId());
				}
			});
		}
		return super.save(object);
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
