package com.eriksostenes.java.services;

import com.eriksostenes.java.domain.Apple;
import com.eriksostenes.java.domain.Predicate;

public class AppleColorPredicate implements Predicate<Apple> {
    private final String color;

    public AppleColorPredicate(String color) {
        this.color = color;
    }

    @Override
    public boolean test(Apple apple) {
        return color.equalsIgnoreCase(apple.color());
    }
}
