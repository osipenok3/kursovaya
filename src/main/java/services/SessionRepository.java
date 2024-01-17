package services;

import models.Session;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessionRepository {

    public List<Session> getSessionsByIdFilm(int film) {
        List<Session> sessions = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT * from sessions where film=";
        ResultSet resultSet = dataBaseService.select(sql+film);
        try {
            while (resultSet.next()) {
                Session session = new Session(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("date"),
                        resultSet.getInt("hall"),
                        resultSet.getInt("film")
                );
                sessions.add(session);
            }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return sessions;
    }

    public Session getSessionById(int id) {
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT * from sessions where id=";
        ResultSet resultSet = dataBaseService.select(sql+id);
        try {
            if (resultSet.next()) {
                return new Session(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("date"),
                        resultSet.getInt("hall"),
                        resultSet.getInt("film")
                );
            }
            else {
                throw new IllegalArgumentException("No session with id "+id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
