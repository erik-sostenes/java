package com.eriksostenes.java.domain;


/**
 * FruitNoContent extends of DomainError, this class is used when no Apples are found with the features you are trying to find.
 */
public class FruitNoFound extends DomainError {
    /**
     * The constructor is used to initialize the detailed error message required by the DomainError class.
     */
    public FruitNoFound() {
        super("No apples found");
    }
}
