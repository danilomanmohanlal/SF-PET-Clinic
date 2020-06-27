package com.example.springframework.services.map;

import com.example.springframework.model.Pet;
import com.example.springframework.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

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
