package services;

import models.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository {

    public List<Ticket> getTicketByIdUser(int user) {
        List<Ticket> tickets = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT t.id, f.name AS film, s.date, h.id AS hall, pl.row, pl.place, p.price, t.sold, t.id_users \n" +
                "FROM tickets t\n" +
                "JOIN sessions s ON t.id_sessions = s.id \n" +
                "JOIN places pl ON t.place = pl.id \n" +
                "JOIN halls h ON s.hall = h.id\n" +
                "JOIN films f ON s.film = f.id\n" +
                "JOIN price p ON pl.category = p.id\n" +
                "WHERE t.id_users =";
        ResultSet resultSet = dataBaseService.select(sql+user);
        try {
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getString("film"),
                        resultSet.getTimestamp("date"),
                        resultSet.getInt("hall"),
                        resultSet.getInt("row"),
                        resultSet.getInt("place"),
                        resultSet.getFloat("price"),
                        resultSet.getBoolean("sold"),
                        resultSet.getInt("id_users")
                );
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tickets;
    }

    public Ticket getTicketId(int id_session, int id_place) {
        DataBaseService dataBaseService = new DataBaseService();
        String sql1 =
                "SELECT t.id, f.name AS film, s.date, h.id AS hall, pl.row, pl.place, p.price, t.sold, t.id_users \n" +
                "FROM tickets t\n" +
                "JOIN sessions s ON t.id_sessions = s.id \n" +
                "JOIN places pl ON t.place = pl.id \n" +
                "JOIN halls h ON s.hall = h.id\n" +
                "JOIN films f ON s.film = f.id\n" +
                "JOIN price p ON pl.category = p.id\n" +
                "WHERE t.id_sessions =";
        String sql2 = " AND t.place =";
        ResultSet resultSet = dataBaseService.select(sql1 + id_session + sql2 + id_place);
        try {
            if (resultSet.next()) {
                return new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getString("film"),
                        resultSet.getTimestamp("date"),
                        resultSet.getInt("hall"),
                        resultSet.getInt("row"),
                        resultSet.getInt("place"),
                        resultSet.getFloat("price"),
                        resultSet.getBoolean("sold"),
                        resultSet.getInt("id_users")
                );
            }
            else {
                throw new IllegalArgumentException("No data with id_session " + id_session + "and id_place" + id_place);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public Ticket getTicketById(int ticket) {
        DataBaseService dataBaseService = new DataBaseService();
        String sql =
                "SELECT t.id, f.name AS film, s.date, h.id AS hall, pl.row, pl.place, p.price, t.sold, t.id_users \n" +
                "FROM tickets t\n" +
                "JOIN sessions s ON t.id_sessions = s.id \n" +
                "JOIN places pl ON t.place = pl.id \n" +
                "JOIN halls h ON s.hall = h.id\n" +
                "JOIN films f ON s.film = f.id\n" +
                "JOIN price p ON pl.category = p.id\n" +
                "WHERE t.id =";
        ResultSet resultSet = dataBaseService.select(sql + ticket);
        try {
            if (resultSet.next()) {
                return new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getString("film"),
                        resultSet.getTimestamp("date"),
                        resultSet.getInt("hall"),
                        resultSet.getInt("row"),
                        resultSet.getInt("place"),
                        resultSet.getFloat("price"),
                        resultSet.getBoolean("sold"),
                        resultSet.getInt("id_users")
                );
            }
            else {
                throw new IllegalArgumentException("No data with id_ticket " + ticket);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void setStatusTicket(int id_users, int id){
        DataBaseService dataBaseService = new DataBaseService();
        String sql1 = "UPDATE tickets SET sold = true, id_users =";
        String sql2 ="WHERE id =";
        dataBaseService.select(sql1 + id_users + sql2 + id);
    }

}
