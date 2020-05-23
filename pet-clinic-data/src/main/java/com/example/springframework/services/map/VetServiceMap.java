package com.example.springframework.services.map;

import com.example.springframework.model.Specialty;
import com.example.springframework.model.Vet;
import com.example.springframework.services.SpecialtyService;
import com.example.springframework.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

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
        Set<Specialty> specialties = Object.getSpecialties();
        if (specialties.size() > 0) {
            for (Specialty specialty : specialties) {
                if (specialty.getId() == null) {
                    Specialty save = specialtyService.save(specialty);
                    specialty.setId(save.getId());
                }
            }
        }

        return super.save(Object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
