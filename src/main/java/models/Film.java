package models;

import java.sql.Date;
import java.sql.Time;

public class Film {
    private int id;
    private String name;
    private String country;
    private Date date_from;
    private String genre;
    private Time duration;
    private String name_file;


    public Film(int id, String name, String country, Date date_from, String genre, Time duration, String name_file) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.date_from = date_from;
        this.genre = genre;
        this.duration = duration;
        this.name_file = name_file;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getName_file() {
        return name_file;
    }

    public void setName_file(String name_file) {
        this.name_file = name_file;
    }


}

