package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    Long id = 1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(),
                new PetServiceMap());

        ownerServiceMap.save(Owner.builder().id(id).lastName("Owner").build());
    }

    @Test
    @Order(1)
    void findAll() throws Exception {
        Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(owners.size(), 1, "owners list should have at least one owner");
    }

    @Test
    @Order(2)
    void findById() throws Exception {
        Owner owner = ownerServiceMap.findById(id);

        assertEquals(owner.getId(), id, "Ids should equal");
    }

    @Test
    @Order(3)
    void save() {
        Owner owner = Owner.builder().id(2L).firstName("Test").lastName(
                "Owner").build();
        Owner savedOwner = ownerServiceMap.save(owner);

        assertEquals(savedOwner, owner, "Owner should be saved");
    }

    @Test
    @Order(4)
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName("Owner");

        assertEquals(owner.getLastName(), "Owner");
    }

    @Test
    void delete() throws Exception {
        Owner owner = Owner.builder().id(id).build();
        ownerServiceMap.delete(owner);

        assertNull(ownerServiceMap.findById(1L), "Owner should remove");
    }

    @Test
    void deleteById() throws Exception {
        ownerServiceMap.deleteById(2L);

        assertNull(ownerServiceMap.findById(2L), "Owner should remove");

    }


}