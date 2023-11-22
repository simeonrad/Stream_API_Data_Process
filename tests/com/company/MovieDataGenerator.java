package com.company;

import com.company.models.Customer;
import com.company.models.Genre;
import com.company.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDataGenerator {
    public static List<Customer> generateData() {
        var starWars = new Movie("Star Wards", Genre.FANTASY);
        var harryPotter = new Movie("Harry Potter", Genre.FANTASY);
        var lordOfTheRings = new Movie("LordOfTheRings", Genre.FANTASY);
        var titanic = new Movie("Titanic", Genre.DRAMA);
        var theNotebook = new Movie("The Notebook", Genre.DRAMA);
        var fastAndFurious = new Movie("Fast and Furious", Genre.ACTION);
        var theExpendables = new Movie("The Expendables", Genre.ACTION);

        List<Customer> customers = new ArrayList<>();

        var jimmy = new Customer(21, "Jimmy", List.of(lordOfTheRings, starWars));
        var steven = new Customer(22, "Steven", List.of(lordOfTheRings, starWars, harryPotter));
        var tommy = new Customer(32, "Tommy", List.of(fastAndFurious, theExpendables));
        var david = new Customer(31, List.of(titanic), "David", List.of(lordOfTheRings, starWars));
        var trevor = new Customer(25, List.of(theExpendables, theNotebook), "Trevor", List.of(lordOfTheRings));
        var claudio = new Customer(21, "Claudio", List.of(titanic, theNotebook, harryPotter));
        var harry = new Customer(26, "Harry", List.of(fastAndFurious, starWars));
        var aaron = new Customer(20, "Aaron", List.of(theExpendables, lordOfTheRings));
        var walter = new Customer(40, "Walter", List.of(theNotebook, starWars));
        var skylar = new Customer(35, List.of(harryPotter), "Skylar", List.of(theExpendables, theNotebook));
        var justin = new Customer(21, "Justin", List.of(lordOfTheRings, starWars));

        customers.add(jimmy);
        customers.add(steven);
        customers.add(tommy);
        customers.add(david);
        customers.add(trevor);
        customers.add(claudio);
        customers.add(harry);
        customers.add(aaron);
        customers.add(walter);
        customers.add(skylar);
        customers.add(justin);

        return customers;
    }
}
