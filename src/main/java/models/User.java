package models;

import javax.servlet.http.HttpServletRequest;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;

    public User(int id, String name, String login,String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(HttpServletRequest req) {
        this.login = req.getParameter("login");
        this.password = req.getParameter("password");
        this.name = req.getParameter("name");
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
