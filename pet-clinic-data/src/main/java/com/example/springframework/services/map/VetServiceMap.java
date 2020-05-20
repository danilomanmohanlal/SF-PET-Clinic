package com.example.springframework.services.map;

import com.example.springframework.model.Vet;
import com.example.springframework.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet Object) {
        super.delete(Object);
    }

    @Override
    public Vet save(Vet Object) {
        return super.save(Object.getId(), Object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
