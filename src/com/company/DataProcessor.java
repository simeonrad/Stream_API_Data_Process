package com.company;

import com.company.models.Customer;
import com.company.models.Genre;
import com.company.models.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessor {

    public static long countCustomersAboveTargetAge(List<Customer> customers, int targetAge) {
        return customers.stream()
                .filter(customer -> customer.getAge() > targetAge)
                .count();
        //DONE
    }

    /**
     * Hint: Is there a method on streams that asks the question "Do all elements match a given condition?"
     */
    public static boolean findIfAllCustomersAreAboveTargetAge(List<Customer> customers, int targetAge) {
        return customers.stream().allMatch(age -> age.getAge() > targetAge);
        //DONE
    }

    /**
     * Hint: Is there a method on streams that asks the question "Does any element match a given condition?"
     */
    public static boolean findIfAnyCustomersHasTargetName(List<Customer> customers, String targetName) {
        return customers.stream().anyMatch(name -> name.getName().equals(targetName));
        //DONE
    }

    /**
     * Hint: Is there a method on streams that asks the question "Do all element match a given condition?"
     */
    public static boolean findIfAllCustomersDislikeMovie(List<Customer> customers, Movie targetMovie) {
        return customers.stream().allMatch(movie -> movie.getDislikedMovies().contains(targetMovie));
        //DONE
    }

    /**
     * Hint: What method on streams eliminates elements, based on some condition?
     */
    public static long findHowManyPeopleLikeMove(List<Customer> customers, Movie targetMovie) {
        return customers.stream()
                .flatMap(customer -> customer.getLikedMovies().stream())
                .filter(movie -> movie.equals(targetMovie))
                .count();
        //DONE
    }

    /**
     * Hint: Is there a method on streams that can eliminate elements from a collection, based on some condition? Also,
     * is there a method that transforms one thing into another thing?
     */
    public static double findTheAverageAgeOfPeopleWhoDislikeMovies(List<Customer> customers, Movie targetMovie) {
        return customers.stream()
                .filter(customer -> customer.getDislikedMovies().contains(targetMovie))
                .mapToDouble(Customer::getAge)
                .average()
                .orElse(0); //This handles the empty result; It is providing a default value if the stream is empty.
        //Somehow it does not work without it!!!
        //DONE
    }

    /**
     * Hint: There is a method average() but we can use it on numeric types only. What method transforms
     * streams from one type to another?
     */
    public static double findAverageAgeOfAllCustomers(List<Customer> customers) {
        return customers.stream()
                .mapToDouble(Customer::getAge)
                .average()
                .orElse(0);//This handles the empty result; It is providing a default value if the stream is empty.
        //Somehow it does not work without it!!!
    }

    /**
     * Hint: First, we need to eliminate all customers whose age is below the targetAge. Then, we need to eliminate
     * all customers who do not have any movies with the targetGenre in their list of likedMovies.
     */
    public static List<Customer> findAllCustomersAboveTargetAgeThatLikeGenre(List<Customer> customers, int targetAge, Genre targetGenre) {
        return customers.stream()
                .filter(customer -> customer.getAge() > targetAge)
                .filter(customer -> customer.getLikedMovies().stream()
                        .anyMatch(movie -> movie.getGenre().equals(targetGenre))).
                collect(Collectors.toList());
        //DONE
    }

    /**
     * Hint: Eliminate all customers with age below the targetAge.
     */
    public static List<Customer> findAllCustomersUnderTargetAge(List<Customer> customers, int targetAge) {
        return customers.stream()
                .filter(customer -> customer.getAge()<targetAge)
                .collect(Collectors.toList());
        //DONE
    }

    /**
     * Hint: https://www.baeldung.com/java-stream-reduce
     */
    public static Customer findTheCustomerWithTheLongestName(List<Customer> customers) {
        return customers.stream()
                .reduce((c1, c2) -> c1.getName().length() > c2.getName().length() ? c1 : c2).orElse(null);
        //DONE
    }

    /**
     * Hint: From the list of customers, eliminate the ones whose list of movies
     * has a movie with a genre, different than the targetGenre.
     */
    public static List<Customer> findAllCustomersWhoLikeOnlyMoviesWithGenre(List<Customer> customers, Genre targetGenre) {
        return customers.stream()
                .filter(customer -> customer.getLikedMovies().stream()
                        .allMatch(movie -> movie.getGenre().equals(targetGenre)))
                .collect(Collectors.toList());
        //DONE
    }
}
