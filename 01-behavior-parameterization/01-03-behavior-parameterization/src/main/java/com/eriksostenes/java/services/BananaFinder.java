package com.eriksostenes.java.services;

import com.eriksostenes.java.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BananaFinder {
    private final FruitRepository<Banana> repository;
    private final FruitFilterHandler fruitFilterHandler;

    public BananaFinder(FruitRepository<Banana> repository) {
        this.repository = repository;
        this.fruitFilterHandler = new FruitFilterHandler();
    }

    public ArrayList<Banana> find() {
        var bananas = this.repository.searchAll();

        if (bananas.filter(ArrayList::isEmpty).isPresent())
                throw new FruitNoFound();

        return bananas.get();
    }

    public ArrayList<Banana> findByColor(String color) {
        var bananas = this.fruitFilterHandler.filter(this.find(), new BananaColorPredicate(color));

        if (bananas.filter(ArrayList::isEmpty).isPresent())
            throw new FruitNoContent(color);

        return bananas.get();
    }
}