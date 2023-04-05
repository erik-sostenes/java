package com.eriksostenes.java.services;

import com.eriksostenes.java.domain.Apple;
import com.eriksostenes.java.domain.AppleNoFound;
import com.eriksostenes.java.domain.AppleRepository;
import com.eriksostenes.java.domain.Predicate;
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
     * @throws AppleNoFound if the list is empty
     */
    public ArrayList<Apple> find() {
        var apples = repository.searchAll();

        if (apples.filter(ArrayList::isEmpty).isPresent()) throw new AppleNoFound();

        return apples.get();
    }


    /**
     * findApplesByColor method that creates a new list of apples based on the requirements of the parameter values.
     * In this case it is necessary to filter by color.
     *
     * @param predicate the parameter behavior
     * @return a new list of apples with the requirements that were requested
     */
    public ArrayList<Apple> findApplesByColor(Predicate predicate) {
        return (ArrayList<Apple>) this.find().stream()
                // .filter(a -> predicate.test(a))
                .filter(predicate::test)
                .collect(Collectors.toList());
    }

    /**
     * findApplesByWeight method that creates a new list of apples based on the requirements of the parameter values.
     * In this case it is necessary to filter by weight.
     *
     * @param predicate the parameter behavior
     * @return a new list of apples with the requirements that were requested
     */
    public ArrayList<Apple> findApplesByWeight(Predicate predicate) {
        return (ArrayList<Apple>) this.find().stream()
                .filter(predicate::test)
                .collect(Collectors.toList());
    }
}
