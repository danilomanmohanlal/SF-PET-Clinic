package com.example.springframework.services.springdatajpa;

import com.example.springframework.model.Visit;
import com.example.springframework.repositories.VisitRepository;
import com.example.springframework.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> res = new HashSet<>();
        visitRepository.findAll().forEach(res::add);
        return res;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit Object) {
        return visitRepository.save(Object);
    }

    @Override
    public void delete(Visit Object) {
        visitRepository.delete(Object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
