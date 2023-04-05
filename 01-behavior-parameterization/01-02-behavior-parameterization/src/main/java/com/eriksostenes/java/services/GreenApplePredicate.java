package com.eriksostenes.java.services;

import com.eriksostenes.java.domain.Apple;
import com.eriksostenes.java.domain.Predicate;

public class GreenApplePredicate implements Predicate {
    private static final String GREEN = "GREEN";

    @Override
    public boolean test(Apple apple) {
        return GREEN.equalsIgnoreCase(apple.color());
    }
}
