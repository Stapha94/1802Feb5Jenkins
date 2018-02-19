package com.revature.beans;

import java.util.Objects;

public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private String favoriteQuote;

    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName, String favoriteQuote) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteQuote = favoriteQuote;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFavoriteQuote() {
        return favoriteQuote;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFavoriteQuote(String favoriteQuote) {
        this.favoriteQuote = favoriteQuote;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", favoriteQuote='" + favoriteQuote + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                Objects.equals(firstName, teacher.firstName) &&
                Objects.equals(lastName, teacher.lastName) &&
                Objects.equals(favoriteQuote, teacher.favoriteQuote);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, favoriteQuote);
    }
}
