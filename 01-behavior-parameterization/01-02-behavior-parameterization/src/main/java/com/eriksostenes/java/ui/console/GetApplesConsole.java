package com.eriksostenes.java.ui.console;

import com.eriksostenes.java.domain.Apple;
import com.eriksostenes.java.domain.AppleNoFound;
import com.eriksostenes.java.domain.Predicate;
import com.eriksostenes.java.infrastructure.persistence.InMemoryAppleRepository;
import com.eriksostenes.java.services.AppleFinder;
import com.eriksostenes.java.services.AppleWeightPredicate;
import com.eriksostenes.java.services.GreenApplePredicate;

/**
 * Print the results on the console
 */
public class GetApplesConsole {
    public static void main(String[] args) {
        try {
            var repository = new InMemoryAppleRepository();
            var services = new AppleFinder(repository);

            System.out.println(services.findApplesByColor(new GreenApplePredicate()));
            System.out.println(services.findApplesByWeight(new AppleWeightPredicate()));

            System.out.println(services.findApplesByColor(new Predicate() {
                private static final String GREEN = "GREEN";
                @Override
                public boolean test(Apple apple) {
                    return GREEN.equalsIgnoreCase(apple.color());
                }
            }));

            System.out.println(services.findApplesByWeight((Apple apple) -> apple.weight() > 150));

        } catch (AppleNoFound e) {
            System.out.println(e.errorMessage());
        }
    }
}
