package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new OwnerSDJpaService(ownerRepository);
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();

        owners.add(returnOwner);

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> ownerList = service.findAll();

        assertArrayEquals(owners.toArray(), ownerList.toArray());
        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(1L)).thenReturn(Optional.ofNullable(returnOwner));

        Owner owner = service.findById(1L);

        assertEquals(owner, returnOwner);
        verify(ownerRepository).findById(any());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner owner = service.save(returnOwner);

        assertEquals(owner, returnOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnOwner.getId());

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() throws Exception {
        when(ownerRepository.findByLastName(any())).thenReturn(this.returnOwner);

        Owner owner = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}
