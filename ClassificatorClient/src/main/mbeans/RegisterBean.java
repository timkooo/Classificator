package main.mbeans;

import main.ejb.UserDAO;
import main.entity.UsersEntity;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by timko_000 on 28.04.2014.
 */
@Named(value = "registerBean")
@RequestScoped
public class RegisterBean {

    @EJB
    UserDAO userDAO;

    UsersEntity user = new UsersEntity();

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public String addNewUser() {
        userDAO.addNewUser(user);
        return "login";
    }

}
