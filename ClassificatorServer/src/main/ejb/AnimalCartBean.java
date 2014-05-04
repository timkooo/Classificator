package main.ejb;

import main.entity.AnimalsEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timko_000 on 24.04.2014.
 */
@Stateful(name = "AnimalCartBean")
public class AnimalCartBean {
    public AnimalCartBean() {
    }

    private List<AnimalsEntity> animalList;

    @PostConstruct
    public void init() {
        if (animalList == null) {
            animalList = new ArrayList<AnimalsEntity>();
        }
    }

    public List<AnimalsEntity> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<AnimalsEntity> animalList) {
        this.animalList = animalList;
    }


    public Integer getAnimalCartSize() {
        return animalList.size();
    }

    public void addAnimalsToCart(List<AnimalsEntity> list) {
        animalList.addAll(list);
    }

    public void removeAnimalsFromCart() {
        animalList.clear();
    }
}
