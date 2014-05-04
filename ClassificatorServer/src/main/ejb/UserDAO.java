package main.ejb;

import main.entity.UsersEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by timko_000 on 27.04.2014.
 */
@Stateless(name = "UserDAO")
public class UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    public UserDAO() {
    }

    public UsersEntity findUser(String name) {
        try {
            javax.persistence.Query query = entityManager.createQuery("select s from UsersEntity s where s.userLogin like :userLogin");
            query.setParameter("userLogin", name);
            return (UsersEntity)query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void addNewUser(UsersEntity user) {
        entityManager.persist(user);
    }

}
