package com.company.models;

import java.util.Objects;

public class Movie {
    private String name;
    private Genre genre;

    public Movie(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return getName().equals(movie.getName()) &&
                getGenre() == movie.getGenre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGenre());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", genre=" + genre +
                '}';
    }
}
