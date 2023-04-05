package com.eriksostenes.java.services;


import com.eriksostenes.java.domain.Fruit;
import com.eriksostenes.java.domain.Predicate;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class FruitFilterHandler {
    public <T extends Fruit> Optional<ArrayList<T>> filter(ArrayList<T> list, Predicate<T> predicate) {
        return Optional.of((ArrayList<T>) list.stream()
                .filter(predicate::test)
                .collect(Collectors.toList()));
    }
}