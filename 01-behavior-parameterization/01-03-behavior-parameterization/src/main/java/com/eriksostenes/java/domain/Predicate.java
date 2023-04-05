package com.eriksostenes.java.domain;

@FunctionalInterface
public interface Predicate<T extends Fruit> {
    boolean test(T t);
}