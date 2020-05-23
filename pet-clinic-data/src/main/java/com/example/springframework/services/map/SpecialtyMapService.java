package com.example.springframework.services.map;

import com.example.springframework.model.Specialty;
import com.example.springframework.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty Object) {
        super.delete(Object);
    }

    @Override
    public Specialty save(Specialty Object) {
        return super.save(Object);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
