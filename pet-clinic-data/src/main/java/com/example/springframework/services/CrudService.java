package com.example.springframework.services;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T Object);

    void delete(T Object);

    void deleteById(ID id);

}
