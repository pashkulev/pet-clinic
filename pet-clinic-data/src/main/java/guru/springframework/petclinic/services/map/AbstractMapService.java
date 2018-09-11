package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(this.map.values());
    }

    T findById(ID id) {
        return this.map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(this.getNextId());
            }

            this.map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object can not be null!");
        }

        return object;
    }

    void deleteById(ID id) {
        this.map.remove(id);
    }

    void delete(T object) {
        this.map.entrySet().removeIf(e -> e.getValue().equals(object));
    }

    private Long getNextId() {
        try {
            return Collections.max(this.map.keySet()) + 1;
        } catch (NoSuchElementException ex) {
            return 1L;
        }
    }
}
