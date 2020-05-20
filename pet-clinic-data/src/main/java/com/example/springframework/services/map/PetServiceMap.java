package com.example.springframework.services.map;

import com.example.springframework.model.Pet;
import com.example.springframework.services.CrudService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

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
        return super.save(2l, Object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
