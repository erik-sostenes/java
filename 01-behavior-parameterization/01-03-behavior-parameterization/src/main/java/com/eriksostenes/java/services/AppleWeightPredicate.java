package com.eriksostenes.java.services;

import com.eriksostenes.java.domain.Apple;
import com.eriksostenes.java.domain.Predicate;

public class AppleWeightPredicate implements Predicate<Apple> {
    private final int weight;

    public AppleWeightPredicate(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean test(Apple apple) {
        return apple.weight() > weight;
    }
}
