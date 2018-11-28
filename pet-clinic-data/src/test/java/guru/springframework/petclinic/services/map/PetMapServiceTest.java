package guru.springframework.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.petclinic.model.Pet;

/**
 * Created by piyush.b.kumar on Nov 28, 2018
 */
class PetMapServiceTest {

	private PetMapService petMapService;

	private final Long petId = 1L;

	@BeforeEach
	void setUp() throws Exception {
		petMapService = new PetMapService();
		petMapService.save(Pet.builder().id(petId).build());
	}

	@Test
	void testFindAll() {
		Set<Pet> petSet = petMapService.findAll();
		assertEquals(1, petSet.size());
	}

	@Test
	void testFindByIdExistingId() {
		Pet pet = petMapService.findById(petId);
		assertEquals(petId, pet.getId());
	}

	@Test
	void testFindByIdNotExistingId() {
		Pet pet = petMapService.findById(5L);
		assertNull(pet);
	}

	@Test
	void testFindByIdNullId() {
		Pet pet = petMapService.findById(null);
		assertNull(pet);
	}

	@Test
	void testSaveExistingId() {
		Long id = 2L;
		Pet pet2 = Pet.builder().id(id).build();
		Pet savedPet = petMapService.save(pet2);
		assertEquals(id, savedPet.getId());
		assertEquals(2, petMapService.findAll().size());
	}

	@Test
	void testSaveDuplicateId() {
		Long id = 1L;
		Pet pet2 = Pet.builder().id(id).build();
		Pet savedPet = petMapService.save(pet2);
		assertEquals(id, savedPet.getId());
		assertEquals(1, petMapService.findAll().size());
	}

	@Test
	void testSaveNoId() {
		Pet savedPet = petMapService.save(Pet.builder().build());
		assertNotNull(savedPet);
		assertNotNull(savedPet.getId());
		assertEquals(2, petMapService.findAll().size());
	}

	@Test
	void testDeleteByIdCorrectId() {
		petMapService.deleteById(petId);
		assertEquals(0, petMapService.findAll().size());
	}

	@Test
	void testDeleteByIdWrongId() {
		petMapService.deleteById(5L);
		assertEquals(1, petMapService.findAll().size());
	}

	@Test
	void testDeleteByIdNullId() {
		petMapService.deleteById(null);
		assertEquals(1, petMapService.findAll().size());
	}

	@Test
	void testDelete() {
		petMapService.delete(petMapService.findById(petId));
		assertEquals(0, petMapService.findAll().size());
	}

	@Test
	void testDeleteWithWrongId() {
		Pet pet = Pet.builder().id(5L).build();
		petMapService.delete(pet);
		assertEquals(1, petMapService.findAll().size());
	}

	@Test
	void testDeleteWithNullId() {
		Pet pet = Pet.builder().build();
		petMapService.delete(pet);
		assertEquals(1, petMapService.findAll().size());
	}

	@Test
	void testDeleteNull() {
		petMapService.delete(null);
		assertEquals(1, petMapService.findAll().size());
	}

}
