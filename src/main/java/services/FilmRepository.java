package services;

import models.Film;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmRepository {

    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT * from films;";
        ResultSet resultSet = dataBaseService.select(sql);
        try {
            while (resultSet.next()) {
                Film film = new Film(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getDate("date_from"),
                        resultSet.getString("genre"),
                        resultSet.getTime("duration"),
                        resultSet.getString("name_file")
                );
                films.add(film);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return films;
    }

    public Film getFilmById(int id) {
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT * from films where id=";
        ResultSet resultSet = dataBaseService.select(sql+id);
        try {
            if (resultSet.next()) {
                return new Film(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getDate("date_from"),
                        resultSet.getString("genre"),
                        resultSet.getTime("duration"),
                        resultSet.getString("name_file")
                );
            }
            else {
                throw new IllegalArgumentException("No film with id "+id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
