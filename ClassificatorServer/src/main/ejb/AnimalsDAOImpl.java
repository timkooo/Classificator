package main.ejb;

import main.entity.AnimalsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by timko_000 on 19.04.2014.
 */
@Stateless(name = "AnimalsDAO")
public class AnimalsDAOImpl implements AnimalsDAO {
    public AnimalsDAOImpl() {
    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addNewAnimal(AnimalsEntity animal) {
        entityManager.persist(animal);
    }

    @Override
    public void updateAnimal(AnimalsEntity animal) {
        entityManager.merge(animal);
    }

    @Override
    public AnimalsEntity findAnimal(String name) {
        javax.persistence.Query query = entityManager.createQuery("select s from AnimalsEntity s where s.animalName like :animalName");
        query.setParameter("animalName", name);
        return (AnimalsEntity)query.getSingleResult();
       // return entityManager.find(AnimalsEntity.class, animalId);
    }

    @Override
    public List<AnimalsEntity> findAllAnimals() {
        TypedQuery<AnimalsEntity> query = entityManager.createQuery("select s from AnimalsEntity s", AnimalsEntity.class);
        return query.getResultList();
    }
    @Override
    public void removeAnimal(AnimalsEntity animal) {
        entityManager.remove(entityManager.find(AnimalsEntity.class, animal.getAnimalId()));
    }

    @Override
    public void removeAllAnimals() {
        entityManager.createQuery("delete from AnimalsEntity").executeUpdate();
    }

    @Override
    public void removeAnimals(List<AnimalsEntity> list) {
        for (AnimalsEntity entity: list) {
           AnimalsEntity a = entityManager.merge(entity);
           entityManager.remove(a);
        }
    }
}
