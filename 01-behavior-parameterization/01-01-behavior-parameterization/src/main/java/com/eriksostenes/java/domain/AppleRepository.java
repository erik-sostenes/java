package com.eriksostenes.java.domain;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Interface that defines the methods contained in our Apple Store
 */
public interface AppleRepository {
    /**
     * Method that searches for all Apples in the store
     * @return List of Apples
     */
    Optional<ArrayList<Apple>> searchAll();
}