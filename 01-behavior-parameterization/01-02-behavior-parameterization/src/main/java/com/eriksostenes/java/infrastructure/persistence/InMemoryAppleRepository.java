package com.eriksostenes.java.infrastructure.persistence;

import com.eriksostenes.java.domain.Apple;
import com.eriksostenes.java.domain.AppleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

/**
 * InMemoryAppleRepository represents the store of our application, all the data will be stored in an ArrayList.
 * By default, every time the application is run, predefined data will already exist.
 */
@Repository
public class InMemoryAppleRepository implements AppleRepository {

    /**
     * apples is an ArrayList of type Apple with predefined values.
     */
    private final ArrayList<Apple> apples = new ArrayList<>() {
        {
            add(new Apple("1", "green", 160D));
            add(new Apple("2", "yellow", 140.5D));
            add(new Apple("3", "green", 139.8D));
            add(new Apple("4", "yellow", 199.D));
        }
    };

    /**
     * Returns a ArrayList of Apples, if the ArrayList is empty returns an empty Optional.
     *
     * @return An Apple collection if ArrayList is not empty
     */
    @Override
    public Optional<ArrayList<Apple>> searchAll() {
        return Optional.ofNullable(apples);
    }
}
