package com.eriksostenes.java.domain;

import static java.lang.String.format;

/**
 * AppleNoContent extends of DomainError, this class is used when no Apples are found with the features you are trying to find.
 */
public class FruitNoContent extends DomainError {

    /**
     * The constructor is used to initialize the detailed error message required by the DomainError class.
     *
     * @param identifier represents the identifier by which the apples are tried to be found.
     */
    public FruitNoContent(String identifier) {
        super(format("The apples <%s> don´t exists", identifier));
    }
}