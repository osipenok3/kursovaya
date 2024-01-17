package models;

import javax.servlet.http.HttpServletRequest;

public class Place {
    private int id;
    private int row;
    private int place;
    private int category;
    private int id_hall;


    public Place(int id, int row, int place, int category, int id_hall) {
        this.id = id;
        this.row = row;
        this.place = place;
        this.category = category;
        this.id_hall = id_hall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getId_hall() {
        return id_hall;
    }

    public void setId_hall(int id_hall) {
        this.id_hall = id_hall;
    }
}