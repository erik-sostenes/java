package com.eriksostenes.java.services;

import com.eriksostenes.java.domain.Apple;
import com.eriksostenes.java.domain.FruitNoContent;
import com.eriksostenes.java.domain.FruitNoFound;
import com.eriksostenes.java.domain.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AppleFinder extends FruitFilterHandler {
    private final FruitRepository<Apple> repository;

    public AppleFinder(FruitRepository<Apple> repository) {
        this.repository = repository;
    }

    public ArrayList<Apple> find() {
        var apples = repository.searchAll();

        if (apples.filter(ArrayList::isEmpty).isPresent()) throw new FruitNoFound();

        return apples.get();
    }

   public ArrayList<Apple> findByColor(String color) {
       var apples = filter(this.find(), new AppleColorPredicate(color));

       if (apples.filter(ArrayList::isEmpty).isPresent())
           throw new FruitNoContent(color);

       return apples.get();
    }

    public ArrayList<Apple> findByWeight(Integer weight) {
        var apples = filter(this.find(), new AppleWeightPredicate(weight));

        if(apples.filter(ArrayList::isEmpty).isPresent())
            throw new FruitNoContent(weight.toString());

        return apples.get();
    }
}