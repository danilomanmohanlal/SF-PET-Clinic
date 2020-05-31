package com.example.springframework.repositories;

import com.example.springframework.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VistiRepository extends CrudRepository<Visit, Long> {
}
