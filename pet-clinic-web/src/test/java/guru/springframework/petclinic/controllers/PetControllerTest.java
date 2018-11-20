package guru.springframework.petclinic.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.model.Pet;
import guru.springframework.petclinic.model.PetType;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetService;
import guru.springframework.petclinic.services.PetTypeService;

/**
 * Created by piyush.b.kumar on Nov 20, 2018
 */
@ExtendWith(MockitoExtension.class)
class PetControllerTest {

	@Mock
	PetService petService;

	@Mock
	OwnerService ownerService;

	@Mock
	PetTypeService petTypeService;

	@InjectMocks
	PetController petController;

	MockMvc mockMvc;

	Owner owner;

	Set<PetType> petTypes;

	@BeforeEach
	void setUp() throws Exception {
		owner = Owner.builder().id(1L).build();

		petTypes = new HashSet<>();
		petTypes.add(PetType.builder().id(1L).name("Dog").build());
		petTypes.add(PetType.builder().id(2L).name("Cat").build());

		mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
	}

	@Test
	void testInitCreationForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);

		mockMvc.perform(get("/owners/1/pets/new")).andExpect(status().isOk())
				.andExpect(model().attributeExists("owner")).andExpect(model().attributeExists("pet"))
				.andExpect(view().name("pets/createOrUpdatePetForm"));
	}

	@Test
	void testProcessCreationForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);

		mockMvc.perform(post("/owners/1/pets/new")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/1"));

		verify(petService).save(any());
	}

	@Test
	void testInitUpdateForm() throws Exception {
		when(petService.findById(anyLong())).thenReturn(Pet.builder().id(1L).build());
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);

		mockMvc.perform(get("/owners/1/pets/2/edit")).andExpect(status().isOk())
				.andExpect(model().attributeExists("owner")).andExpect(model().attributeExists("pet"))
				.andExpect(view().name("pets/createOrUpdatePetForm"));
	}

	@Test
	void testProcessUpdateForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);

		mockMvc.perform(post("/owners/1/pets/2/edit")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/1"));

		verify(petService).save(any());
	}

}
