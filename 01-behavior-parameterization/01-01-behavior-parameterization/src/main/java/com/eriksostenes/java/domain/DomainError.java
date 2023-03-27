package com.eriksostenes.java.domain;

/**
 * DomainError extends the RuntimeException superclass to detail our error message
 */
public class DomainError extends RuntimeException {
    /**
     * errorMessage is the error message that will be displayed to the client.
     */
    private final String errorMessage;

    /**
     * Constructor is used to initialize the error message that requires the RuntimeException superclass
     * @param errorMessage represents the detail error message
     */
    public DomainError(String errorMessage) {
        super(errorMessage);

        this.errorMessage = errorMessage;
    }

    /**
     * Returns the detail our error message
     * @return the error message
     */
    public String errorMessage() {
        return this.errorMessage;
    }
}
