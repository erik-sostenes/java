package com.eriksostenes.java.ui.console;

import com.eriksostenes.java.domain.AppleNotFound;
import com.eriksostenes.java.infrastructure.persistence.InMemoryAppleRepository;
import com.eriksostenes.java.services.AppleFinder;

/**
 * Print the results on the console
 */
public class GetApplesConsole {
    public static void main(String[] args) {
      try {
          var repository = new InMemoryAppleRepository();
          var services = new AppleFinder(repository);
          var apples = services.find();

          System.out.println(apples);

          System.out.println(services.findGreenApplesByColor(apples));

          System.out.println(services.findApplesByColor(apples, "yellow"));

          System.out.println(services.findApplesByWeight(apples, 150D));

          System.out.println(services.findApplesByWeightAndColor(apples, "green", 150D));
        }catch (AppleNotFound e) {
           System.out.println(e.errorMessage());
        }
    }
}
