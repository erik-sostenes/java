package com.eriksostenes.java.domain;

/**
 * Apple represents the domain object and DTO(Data Transfer Object).
 *
 * @param id     represents the identifier
 * @param color  represents the color
 * @param weight represents the heavy weight
 */
public record Apple(String id, String color, Double weight) {
}
