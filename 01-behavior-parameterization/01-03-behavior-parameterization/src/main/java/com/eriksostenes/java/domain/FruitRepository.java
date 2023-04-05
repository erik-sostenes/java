package com.eriksostenes.java.domain;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Interface that defines the methods contained in our Apple Store
 */
public interface FruitRepository<T extends Fruit> {
    /**
     * Method that searches for all Apples in the store
     *
     * @return List of Apples
     */
    Optional<ArrayList<T>> searchAll();
}