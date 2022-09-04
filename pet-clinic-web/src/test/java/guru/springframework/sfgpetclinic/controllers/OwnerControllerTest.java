package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class OwnerControllerTest {

    @Mock
    Model model;

    @Mock
    OwnerService ownerService;

    OwnerController ownerController;

    final String BASE_URL = "/owners";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(ownerService);
        Set<Owner> owners = new HashSet<>();

        owners.add(Owner.builder().id(1L).lastName("Smith").build());
        owners.add(Owner.builder().id(2L).lastName("Jon").build());

        when(ownerService.findAll()).thenReturn(owners);
    }

    @Test
    void listOwners() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();

        mockMvc.perform(get(BASE_URL))
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)))
                .andExpect(status().isOk());
        verify(ownerService, times(1)).findAll();
    }


    @Test
    void findOwners() throws Exception {
        MockMvc mockMvc =
                MockMvcBuilders.standaloneSetup(ownerController).build();

        mockMvc.perform(get(BASE_URL + "/find")).andExpect(view().name(
                "notimplemented")).andExpect(status().isOk());
    }
}
