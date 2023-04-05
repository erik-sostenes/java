package com.eriksostenes.java.services;

import com.eriksostenes.java.domain.Apple;
import com.eriksostenes.java.domain.Predicate;

public class AppleWeightPredicate implements Predicate {
    private static final int WEIGHT = 150;

    @Override
    public boolean test(Apple apple) {
        return apple.weight() > WEIGHT;
    }
}
