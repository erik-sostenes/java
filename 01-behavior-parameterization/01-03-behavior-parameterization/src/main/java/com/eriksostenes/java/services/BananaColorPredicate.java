package com.eriksostenes.java.services;

import com.eriksostenes.java.domain.Banana;
import com.eriksostenes.java.domain.Predicate;

public class BananaColorPredicate implements Predicate<Banana> {
    private final String color;

    public BananaColorPredicate(String color) {
        this.color = color;
    }

    @Override
    public boolean test(Banana banana) {
        return this.color.equalsIgnoreCase(banana.color());
    }
}
