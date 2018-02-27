package com.ex.model.chinook;

/**
 * Created by August on 6/18/2017.
 */
public class Genre {
    private long genreId;
    private String name;

    public Genre() {
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
