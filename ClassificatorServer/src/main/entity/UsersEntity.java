package main.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by timko_000 on 04.05.2014.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "ebank")
public class UsersEntity {
    private Integer userId;
    private String userLogin;
    private String userPassword;
    private String userMail;
    private String userType;
    private Collection<CartsEntity> cartsesByUserId;
    private Collection<OrdersEntity> ordersesByUserId;
    private Collection<SessionsEntity> sessionsesByUserId;

    @Id
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_login")
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_mail")
    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    @Basic
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userLogin != null ? !userLogin.equals(that.userLogin) : that.userLogin != null) return false;
        if (userMail != null ? !userMail.equals(that.userMail) : that.userMail != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userLogin != null ? userLogin.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userMail != null ? userMail.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByCartUser")
    public Collection<CartsEntity> getCartsesByUserId() {
        return cartsesByUserId;
    }

    public void setCartsesByUserId(Collection<CartsEntity> cartsesByUserId) {
        this.cartsesByUserId = cartsesByUserId;
    }

    @OneToMany(mappedBy = "usersByOrderUser")
    public Collection<OrdersEntity> getOrdersesByUserId() {
        return ordersesByUserId;
    }

    public void setOrdersesByUserId(Collection<OrdersEntity> ordersesByUserId) {
        this.ordersesByUserId = ordersesByUserId;
    }

    @OneToMany(mappedBy = "usersBySessionUser")
    public Collection<SessionsEntity> getSessionsesByUserId() {
        return sessionsesByUserId;
    }

    public void setSessionsesByUserId(Collection<SessionsEntity> sessionsesByUserId) {
        this.sessionsesByUserId = sessionsesByUserId;
    }
}
