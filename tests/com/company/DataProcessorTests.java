package com.company;

import com.company.models.Customer;
import com.company.models.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.company.DataProcessor.*;

public class DataProcessorTests {
    private List<Customer> customerList = MovieDataGenerator.generateData();

    @Test
    public void findTheAverageAgeOfPeopleWhoDislikeMovies_test() {
        var targetMovie = customerList.get(0).getLikedMovies().get(0);
        var result = findTheAverageAgeOfPeopleWhoDislikeMovies(customerList, targetMovie);

        Assertions.assertEquals(28, result);
    }

    @Test
    public void findHowManyPeopleLikeMove_test() {
        var targetMovie = customerList.get(0).getLikedMovies().get(0);
        var result = findHowManyPeopleLikeMove(customerList, targetMovie);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void findAverageAgeOfAllCustomers_test() {
        var result = findAverageAgeOfAllCustomers(customerList);

        Assertions.assertEquals(26, (int) result);
    }

    @Test
    public void findIfAllCustomersDislikeMovie_test() {
        var targetMovie = customerList.get(0).getLikedMovies().get(0);
        var result = findIfAllCustomersDislikeMovie(customerList, targetMovie);

        Assertions.assertFalse(result);
    }

    @Test
    public void findAllCustomersAboveTargetAgeThatLikeGenre_test() {
        var expected = new ArrayList<>();
        int targetAge = 21;
        var targetGenre = Genre.ACTION;
        for (Customer customer : customerList) {
            if (customer.getAge() > targetAge) {
                for (int j = 0; j < customer.getLikedMovies().size(); j++) {
                    if (customer.getLikedMovies().get(j).getGenre().equals(targetGenre)) {
                        expected.add(customer);
                        break;
                    }
                }
            }
        }
        var actual = findAllCustomersAboveTargetAgeThatLikeGenre(customerList, 21, Genre.ACTION);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void countCustomersAboveTargetAge_test() {
        var result = countCustomersAboveTargetAge(customerList, 21);

        Assertions.assertEquals(7, result);
    }

    @Test
    public void findIfAnyCustomersHasTargetName_test() {
        var result = findIfAnyCustomersHasTargetName(customerList, "Jimmy");

        Assertions.assertTrue(result);
    }

    @Test
    public void findIfAllCustomersAreAboveTargetAge_test() {
        var result = findIfAllCustomersAreAboveTargetAge(customerList, 30);

        Assertions.assertFalse(result);
    }

    @Test
    public void findAllCustomersUnderTargetAge_test() {
        List<Customer> expected = new ArrayList<>();

        int targetAge = 30;
        for (Customer customer : customerList) {
            if (customer.getAge() < targetAge) {
                expected.add(customer);
            }
        }

        var result = findAllCustomersUnderTargetAge(customerList, targetAge);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findTheCustomerWithTheLongestName_test() {
        var result = findTheCustomerWithTheLongestName(customerList);

        Assertions.assertEquals("Claudio", result.getName());
    }

    @Test
    public void findAllCustomersWhoLikeOnlyMoviesWithGenre_test() {
        var targetGenre = Genre.ACTION;
        var expected = getCustomersWhoLikeTargetGenre(customerList, targetGenre);
        var result = findAllCustomersWhoLikeOnlyMoviesWithGenre(customerList, targetGenre);

        Assertions.assertEquals(result, expected);
    }

    private List<Customer> getCustomersWhoLikeTargetGenre(List<Customer> customers, Genre targetGenre) {
        var result = new ArrayList<Customer>();
        for (Customer customer : customers) {
            var customerMovies = customer.getLikedMovies();
            var areSameGenre = false;

            for (int j = 0; j < customerMovies.size() - 1; j++) {
                if (!customerMovies.get(j).getGenre().equals(targetGenre)) break;

                if (customerMovies.get(j).getGenre().equals(customerMovies.get(j + 1).getGenre())) {
                    areSameGenre = true;
                    break;
                }
            }

            if (areSameGenre) {
                result.add(customer);
            }
        }

        return result;
    }
}
