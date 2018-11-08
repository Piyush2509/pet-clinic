package guru.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.petclinic.model.Vet;

/**
 * Created by piyush.b.kumar on Nov 8, 2018
 */
public interface VetRepository extends CrudRepository<Vet, Long> {

}
