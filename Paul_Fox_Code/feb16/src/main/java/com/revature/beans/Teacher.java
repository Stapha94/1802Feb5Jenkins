package com.revature.beans;

import java.util.Objects;

public class Teacher {

    private int id;
    private String firstName;
    private String last_name;
    private String favoriteQuote;

    public Teacher(){

    }

    public Teacher(int id, String firstName, String last_name, String favoriteQuote) {
        this.id = id;
        this.firstName = firstName;
        this.last_name = last_name;
        this.favoriteQuote = favoriteQuote;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLast_name() {
        return last_name;
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

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFavoriteQuote(String favoriteQuote) {
        this.favoriteQuote = favoriteQuote;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", last_name=" + last_name +
                ", favoriteQuote='" + favoriteQuote + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return getId() == teacher.getId() &&
                Objects.equals(getFirstName(), teacher.getFirstName()) &&
                Objects.equals(getLast_name(), teacher.getLast_name()) &&
                Objects.equals(getFavoriteQuote(), teacher.getFavoriteQuote());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLast_name(), getFavoriteQuote());
    }
}
