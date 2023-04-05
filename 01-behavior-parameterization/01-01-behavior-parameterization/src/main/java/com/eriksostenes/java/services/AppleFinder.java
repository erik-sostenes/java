package com.eriksostenes.java.services;

import com.eriksostenes.java.domain.Apple;
import com.eriksostenes.java.domain.AppleNotFound;
import com.eriksostenes.java.domain.AppleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * AppleFinder id the service layer, this class is responsible for finding the apples depending on the requirements
 */
@Service
public class AppleFinder {
    private final AppleRepository repository;

    /**
     * Constructor is used to inject the dependencies that are required
     *
     * @param repository represents the Apple Store
     */
    public AppleFinder(AppleRepository repository) {
        this.repository = repository;
    }

    /**
     * find method that finding the apples of the store
     *
     * @return a list of apples
     * @throws AppleNotFound if the list is empty
     */
    public ArrayList<Apple> find() {
        var apples = repository.searchAll();

        if (apples.filter(ArrayList::isEmpty).isPresent()) throw new AppleNotFound();

        return apples.get();
    }

    /**
     * findGreenApplesByColor method that creates a new list of apples based on the color required.
     *
     * @return a new list of apples with the requirements that were requested
     */
    public ArrayList<Apple> findGreenApplesByColor() {
        return (ArrayList<Apple>) this.find().stream()
                .filter(a -> a.color().equals("green"))
                .collect(Collectors.toList());
    }

    /**
     * findApplesByColor method that creates a new list of apples based on the requirements of the parameter values.
     * In this case it is necessary to filter by color.
     * @param color represents color
     * @return a new list of apples with the requirements that were requested
     */
    public ArrayList<Apple> findApplesByColor(String color) {
        return (ArrayList<Apple>) this.find().stream()
                .filter(a -> a.color().equals(color))
                .collect(Collectors.toList());
    }

    /**
     * findApplesByWeight method that creates a new list of apples based on the requirements of the parameter values.
     * In this case it is necessary to filter by weight.
     *
     * @param weight represents weight
     * @return a new list of apples with the requirements that were requested
     */
    public ArrayList<Apple> findApplesByWeight(Double weight) {
        return (ArrayList<Apple>) this.find().stream()
                .filter(a -> a.weight() > weight)
                .collect(Collectors.toList());
    }

    /**
     * findApplesByWeightAndColor method that creates a new list of apples based on the requirements of the parameter
     * values.
     * In this case it is necessary to filter by color and weight.
     *
     * @param color represents color
     * @param weight represents weight
     * @return a new list of apples with the requirements that were requested
     */
    public ArrayList<Apple> findApplesByWeightAndColor(String color, Double weight) {
        return (ArrayList<Apple>)  this.find().stream()
                .filter(a -> a.weight() > weight)
                .filter(a -> a.color().equals(color))
                .collect(Collectors.toList());
    }
}
