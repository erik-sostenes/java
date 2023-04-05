package com.eriksostenes.java.domain;

@FunctionalInterface
public interface Predicate {
    boolean test(Apple apple);
}