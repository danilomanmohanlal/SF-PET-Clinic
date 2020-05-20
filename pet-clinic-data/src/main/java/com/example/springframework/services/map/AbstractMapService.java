package com.example.springframework.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> serviceMap = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(serviceMap.values());
    }

    T findById(ID id) {
        return serviceMap.get(id);
    }

    T save(ID id, T object) {
        serviceMap.put(id, object);
        return object;
    }

    void deleteById(ID id) {
        serviceMap.remove(id);
    }

    void delete(T object) {
        serviceMap.entrySet().removeIf(e -> e.getValue().equals(object));
    }

}
