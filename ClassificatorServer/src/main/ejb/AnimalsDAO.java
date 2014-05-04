package main.ejb;

import main.entity.AnimalsEntity;

import java.util.List;

/**
 * Created by timko_000 on 19.04.2014.
 */
public interface AnimalsDAO {

    public void addNewAnimal(AnimalsEntity animal);

    public void updateAnimal(AnimalsEntity animal);

    public AnimalsEntity findAnimal(String name);

    public java.util.List<AnimalsEntity> findAllAnimals();

    public void removeAnimal(AnimalsEntity animal);

    public void removeAllAnimals();

    public void removeAnimals(List<AnimalsEntity> list);

}
