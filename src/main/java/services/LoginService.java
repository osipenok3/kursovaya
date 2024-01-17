package services;

import services.DBLogin;
import services.HashService;

import java.util.Date;

public class LoginService {

    public Boolean auth(String login, String pass){
        HashService hashService = new HashService();
        String passHash = hashService.createHash(pass);
        pass = hashService.createHash(pass);
        DBLogin loginDBService = new DBLogin();
        String getPass = loginDBService.getPassByLogin(login);
        if(getPass != null && passHash.equals(getPass)){
            return true;
        }
        return false;
    }

}
