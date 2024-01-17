package models;

import java.sql.Timestamp;


public class Session {
    private int id;
    private Timestamp date;
    private int hall;
    private int film;

    public Session(int id, Timestamp date, int hall, int film) {
        this.id = id;
        this.date = date;
        this.hall = hall;
        this.film = film;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public int getFilm() {
        return film;
    }

    public void setFilm(int film) {
        this.film = film;
    }
}
