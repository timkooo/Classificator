package main.entity;

import javax.persistence.*;

/**
 * Created by timko_000 on 04.05.2014.
 */
@Entity
@Table(name = "sessions", schema = "public", catalog = "ebank")
public class SessionsEntity {
    private String sessionId;
    private Integer sessionUser;
    private UsersEntity usersBySessionUser;

    @Id
    @Column(name = "session_id")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "session_user")
    public Integer getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(Integer sessionUser) {
        this.sessionUser = sessionUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionsEntity that = (SessionsEntity) o;

        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (sessionUser != null ? !sessionUser.equals(that.sessionUser) : that.sessionUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId != null ? sessionId.hashCode() : 0;
        result = 31 * result + (sessionUser != null ? sessionUser.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "session_user", referencedColumnName = "user_id")
    public UsersEntity getUsersBySessionUser() {
        return usersBySessionUser;
    }

    public void setUsersBySessionUser(UsersEntity usersBySessionUser) {
        this.usersBySessionUser = usersBySessionUser;
    }
}
