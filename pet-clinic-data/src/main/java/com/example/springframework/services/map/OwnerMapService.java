package com.example.springframework.services.map;

import com.example.springframework.model.Owner;
import com.example.springframework.model.Pet;
import com.example.springframework.model.PetType;
import com.example.springframework.services.OwnerService;
import com.example.springframework.services.PetService;
import com.example.springframework.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {

            Set<Pet> pets = object.getPets();
            if (pets != null) {
                pets.forEach( pet -> {
                    PetType petType = pet.getPetType();
                    if (petType.getId() == null) {
                        PetType save = petTypeService.save(pet.getPetType());
                        pet.setPetType(save);
                    }

                    if (pet.getId() == null) {
                        Pet save = petService.save(pet);
                        pet.setId(save.getId());
                    }
                });
            }
            return super.save(object);
        }
        else return null;
    }

    @Override
    public void delete(Owner Object) {
        super.delete(Object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
