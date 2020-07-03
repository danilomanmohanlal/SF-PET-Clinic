package com.example.springframework.services.map;

import com.example.springframework.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    public void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner smith = ownerMapService.save(Owner.builder().id(1L).lastName("Smith").build());
        System.out.println();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner save = ownerMapService.save(owner2);
        assertEquals(id, save.getId());
    }

    @Test
    void delete() {
        Long ownerId = 1L;
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        Long ownerId = 1L;
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findById() {
        Long ownerId = 1L;
        Owner byId = ownerMapService.findById(ownerId);
        assertNotNull(byId);
    }

    @Test
    void findByLastName() {
        String lastname = "Smith";
        Owner owner = ownerMapService.findByLastName(lastname);
        assertNotNull(owner);
    }
}