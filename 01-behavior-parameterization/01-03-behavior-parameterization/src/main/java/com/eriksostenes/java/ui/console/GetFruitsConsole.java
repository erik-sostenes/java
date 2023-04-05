package com.eriksostenes.java.ui.console;

import com.eriksostenes.java.domain.FruitNoContent;
import com.eriksostenes.java.domain.FruitNoFound;
import com.eriksostenes.java.infrastructure.persistence.InMemoryAppleRepository;
import com.eriksostenes.java.infrastructure.persistence.InMemoryBananaRepository;
import com.eriksostenes.java.services.AppleFinder;
import com.eriksostenes.java.services.BananaFinder;

public class GetFruitsConsole {
    public static void main(String[] args) {
        try {
            var inMemoryAppleRepository = new InMemoryAppleRepository();
            var appleFinder = new AppleFinder(inMemoryAppleRepository);

            System.out.println(appleFinder.findByColor("green"));


            var inMemoryBananaRepository = new InMemoryBananaRepository();
            var bananaFinder = new BananaFinder(inMemoryBananaRepository);

            System.out.println(bananaFinder.find());

            System.out.println(bananaFinder.findByColor("YelloW"));

        }catch (FruitNoFound | FruitNoContent e) {
            System.out.println(e.errorMessage());
        }
    }
}
