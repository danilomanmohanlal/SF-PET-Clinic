package com.example.springframework.services.map;

import com.example.springframework.model.Pet;
import com.example.springframework.model.PetType;
import com.example.springframework.services.PetTypeService;

import java.util.Set;

public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType Object) {
        super.delete(Object);
    }

    @Override
    public PetType save(PetType Object) {
        return super.save(Object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
