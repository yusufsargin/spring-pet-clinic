package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class OwnerControllerTest {

    @Mock
    Model model;

    @Mock
    OwnerService ownerService;

    OwnerController ownerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(ownerService);
    }

    @Test
    void listOwners() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();

        mockMvc.perform(get("/owners"))
                .andExpect(view().name("owners/index"))
                .andExpect(status().isOk());
        verify(ownerService, times(1)).findAll();
    }
}
