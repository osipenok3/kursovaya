package services;

import models.Place;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlacesRepository {

    public List<Place> getFreePlacesByIdSession(int session) {
        List<Place> places = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        String sql =
                "SELECT p.id, p.row, p.place, p.category, p.id_hall from places p\n" +
                "JOIN tickets t ON p.id = t.place \n" +
                "WHERE t.sold = false\n" +
                "AND t.id_sessions =";
        ResultSet resultSet = dataBaseService.select(sql+session);
        try {
            while (resultSet.next()) {
                Place place = new Place(
                        resultSet.getInt("id"),
                        resultSet.getInt("row"),
                        resultSet.getInt("place"),
                        resultSet.getInt("category"),
                        resultSet.getInt("id_hall")
                );
                places.add(place);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return places;
    }

}
