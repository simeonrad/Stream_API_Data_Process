package com.company.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    private static int nextId = 0;

    private int id;
    private int age;
    private String name;
    private List<Movie> likedMovies;
    private List<Movie> dislikedMovies;

    private Customer(int id, int age, List<Movie> likedMovies, String name, List<Movie> dislikedMovies) {
        setId(id);
        setAge(age);
        setName(name);
        setLikedMovies(likedMovies);
        setDislikedMovies(dislikedMovies);
    }

    public Customer(int age, List<Movie> likedMovies, String name, List<Movie> dislikedMovies) {
        this(++nextId, age, likedMovies, name, dislikedMovies);
    }

    public Customer(int age, String name, List<Movie> likedMovies) {
        this(age, likedMovies, name, new ArrayList<>());
    }

    public Customer(int age, String name) {
        this(age, new ArrayList<>(), name, new ArrayList<>());
    }

    public static int getNextId() {
        return nextId;
    }

    private static void setNextId(int nextId) {
        Customer.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Movie> getLikedMovies() {
        return likedMovies;
    }

    public void setLikedMovies(List<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public List<Movie> getDislikedMovies() {
        return dislikedMovies;
    }

    public void setDislikedMovies(List<Movie> dislikedMovies) {
        this.dislikedMovies = dislikedMovies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() &&
                getAge() == customer.getAge() &&
                getName().equals(customer.getName()) &&
                getLikedMovies().equals(customer.getLikedMovies()) &&
                getDislikedMovies().equals(customer.getDislikedMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAge(), getName(), getLikedMovies(), getDislikedMovies());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", likedMovies=" + likedMovies +
                ", dislikedMovies=" + dislikedMovies +
                '}';
    }
}
