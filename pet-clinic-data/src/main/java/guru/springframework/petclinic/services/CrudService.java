package guru.springframework.petclinic.services;

import java.util.Set;

/**
 * Created by piyush.b.kumar on Nov 5, 2018
 */
public interface CrudService<T, ID> {

	Set<T> findAll();

	T findById(ID id);

	T save(T object);

	void delete(T object);

	void deleteById(ID id);

}
