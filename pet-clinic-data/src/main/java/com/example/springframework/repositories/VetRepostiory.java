package com.example.springframework.repositories;

import com.example.springframework.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepostiory extends CrudRepository<Vet, Long> {
}
