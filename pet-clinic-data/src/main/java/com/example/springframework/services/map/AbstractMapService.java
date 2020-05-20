package com.example.springframework.services.map;

import com.example.springframework.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> serviceMap = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(serviceMap.values());
    }

    T findById(ID id) {
        return serviceMap.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null)
                object.setId(getNextId());

            serviceMap.put(object.getId(), object);
        } else {
            throw new RuntimeException("object cannot be null");
        }


        return object;
    }

    void deleteById(ID id) {
        serviceMap.remove(id);
    }

    void delete(T object) {
        serviceMap.entrySet().removeIf(e -> e.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(serviceMap.keySet()) + 1;
        } catch (Exception e) {
            nextId = 1L;
        }
        return nextId;
    }

}
