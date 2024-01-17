package models;

import java.sql.Timestamp;

public class Ticket {
    private int id;
    private String film;
    private Timestamp date;
    private int hall;
    private int row;
    private int place;
    private float price;
    private boolean sold;
    private int id_users;

    public Ticket(int id, String film, Timestamp date,  int hall, int row,  int place, float price, boolean sold, int id_users) {
        this.id = id;
        this.film = film;
        this.date = date;
        this.hall = hall;
        this.row = row;
        this.place = place;
        this.price = price;
        this.sold = sold;
        this.id_users = id_users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date){
        this.date = date;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public float getCost() {
        return price;
    }

    public void setCost(float price) {
        this.price = price;
    }

    public boolean getSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public int getId_users() {
        return id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

}

