package com.eriksostenes.java.infrastructure.persistence;

import com.eriksostenes.java.domain.Banana;
import com.eriksostenes.java.domain.FruitRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

/**
 * InMemoryBananaRepository represents the store of our application, all the data will be stored in an ArrayList.
 * By default, every time the application is run, predefined data will already exist.
 */
@Repository
public class InMemoryBananaRepository implements FruitRepository<Banana> {
    /**
     * apples is an ArrayList of type Banana with predefined values.
     */
    private final ArrayList<Banana> bananas = new ArrayList<>() {
        {
            add(new Banana("1", "green", 160D));
            add(new Banana("2", "yellow", 140.5D));
            add(new Banana("3", "green", 139.8D));
            add(new Banana("4", "yellow", 199.D));
        }
    };

    /**
     * Returns a ArrayList of Banana, if the ArrayList is empty returns an empty Optional.
     *
     * @return An Apple collection if ArrayList is not empty
     */
    @Override
    public Optional<ArrayList<Banana>> searchAll() {
        return Optional.ofNullable(bananas);
    }
}
