package services;

import models.Ticket;
import models.User;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "SELECT * from users;";
        ResultSet resultSet = dataBaseService.select(sql);
        try {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public int getIdUserByLogin(String login) {
        Integer id = null;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "select u.\"id\" from users u where u.login = '"+login+"' ";
        ResultSet resultSet = dataBaseService.select(sql);
        try {
            resultSet.next();
            id = resultSet.getInt("id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }


}
