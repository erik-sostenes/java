package com.eriksostenes.java.domain;

/**
 * AppleNoContent extends of DomainError, this class is used when no Apples are found.
 */
public class AppleNoFound extends DomainError {

    /**
     * The constructor is used to initialize the detailed error message required by the DomainError class.
     */
    public AppleNoFound() {
        super("No apples found");
    }
}
