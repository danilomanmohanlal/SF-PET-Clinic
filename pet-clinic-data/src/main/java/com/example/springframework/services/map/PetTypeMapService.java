package com.example.springframework.services.map;

import com.example.springframework.model.Pet;
import com.example.springframework.services.PetTypeService;

import java.util.Set;

public class PetTypeMapService extends AbstractMapService<Pet, Long> implements PetTypeService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet Object) {
        super.delete(Object);
    }

    @Override
    public Pet save(Pet Object) {
        return super.save(Object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
