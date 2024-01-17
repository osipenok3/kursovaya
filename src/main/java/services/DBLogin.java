package services;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBLogin {
    public String getPassByLogin(String login){
        String password = null;
        DataBaseService dataBaseService = new DataBaseService();
        String sql = "select u.\"password\" from users u where u.login = '"+login+"' ";
        ResultSet resultSet = dataBaseService.select(sql);
        try {
            resultSet.next();
            password = resultSet.getString("password");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return password;
    }

}
