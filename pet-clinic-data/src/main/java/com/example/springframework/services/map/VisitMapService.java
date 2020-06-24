package com.example.springframework.services.map;

import com.example.springframework.model.Visit;
import com.example.springframework.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit Object) {
        super.delete(Object);
    }

    @Override
    public Visit save(Visit visit) {

        if (visit.getPet() == null || visit.getPet().getOwner() == null ||
                visit.getPet().getId() == null)
            throw new RuntimeException("Invalid visit!");

        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
