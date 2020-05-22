package com.example.springframework.services;

import com.example.springframework.model.Pet;
import com.example.springframework.services.CrudService;

public interface PetTypeService extends CrudService<Pet, Long> {
}
