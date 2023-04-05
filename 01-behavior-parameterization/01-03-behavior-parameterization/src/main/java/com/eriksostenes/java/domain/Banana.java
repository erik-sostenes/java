package com.eriksostenes.java.domain;

/**
 * Banana represents the domain object and DTO(Data Transfer Object).
 *
 * @param id     represents the identifier
 * @param color  represents the color
 * @param weight represents the heavy weight
 */
public record Banana(String id, String color, Double weight) implements Fruit{
}
