package main.mbeans;

import main.ejb.UserDAO;
import main.entity.UsersEntity;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by timko_000 on 26.04.2014.
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    @EJB
    UserDAO userDAO;

    @Inject
    CookieBean cookieBean;

    @ManagedProperty(value = "#{param.uri}")
    String uri;



    private String login;
    private String password;
    private FacesContext context;
    private UsersEntity user;

   /* public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String doLogin() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        user = userDAO.findUser(login);
        if (user != null) {
            externalContext.getSessionMap().put("user", user);
            cookieBean.addToCookies("userSessionId", login); // добавляем текущую сессию в куки
            return /*uri;*/ externalContext.getRequestParameterMap().get("uri");
        } else {
            return "register";
        }
        /* добавить пользователя в сессию, через логин \ пассворд, найти его в базе, получит сущность и затолкать ее
                в ссессию*/
    }

    public String doLogout() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        externalContext.invalidateSession();
        return "login";
    }

    public boolean isLoggedIn() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        if (externalContext.getSessionMap().get("user") == null) {
       /* if (externalContext.getRemoteUser() == null) {         // говорит есть ли пользователь*/
            return false;
        }
        else return true;
    }

//    добавить добавление сущности в кукез и извлечение


}
