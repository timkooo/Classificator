package main.mbeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.Map;

/**
 * Created by timko_000 on 28.04.2014.
 */
@Named(value = "cookieBean")
@RequestScoped
public class CookieBean {

    public void addToCookies(String name, String property) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.addResponseCookie(name, property, null);
    }

    public void removeFromCookies(String name) {

    }

    public void removeAllFromCookies() {

    }

    public String getFromCookies(String name) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        return (String)externalContext.getRequestCookieMap().get(name);
    }

}
