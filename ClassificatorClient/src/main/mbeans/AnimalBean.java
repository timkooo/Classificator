package main.mbeans;

import main.ejb.AnimalCartBean;
import main.ejb.AnimalsDAO;
import main.entity.AnimalsEntity;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by timko_000 on 19.04.2014.
 */

@Named("animalMBean")
@SessionScoped
public class AnimalBean implements Serializable {

    @Inject
    CartBean cartBean;

    @EJB
//    @Inject
    private AnimalsDAO animalsDAO;

    @EJB
    private AnimalCartBean animalCart;

    private AnimalsEntity animal;
    private List<AnimalsEntity> animalList;
    private List<AnimalsEntity> selectedAnimalList;
    private Map<Integer, Boolean> selected = new HashMap<Integer, Boolean>();

   /* public AnimalMBean() {
        animal = new AnimalsEntity();
    }*/

    @PostConstruct
    private void loadAnimalList() {
        if (animalList == null) {
            animalList = findAllAnimals();
        }
    }

    public Map<Integer, Boolean> getSelected() {
        return selected;
    }

    public void setSelected(Map<Integer, Boolean> selected) {
        this.selected = selected;
    }

    public List<AnimalsEntity> getSelectedAnimalList() {
        return selectedAnimalList;
    }

    public void setSelectedAnimalList(List<AnimalsEntity> selectedAnimalList) {
        this.selectedAnimalList = selectedAnimalList;
    }

    public List<AnimalsEntity> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<AnimalsEntity> animalList) {
        this.animalList = animalList;
    }

    public AnimalsEntity getAnimal() {
        if (animal == null) {
            animal = new AnimalsEntity();
        }
        return animal;
    }

    public void setAnimal(AnimalsEntity animal) {
        this.animal = animal;
    }

    public void addNewAnimal() {
        animalsDAO.addNewAnimal(animal);
        animalList = findAllAnimals();
    }

    public void updateAnimal() {
        animalsDAO.updateAnimal(animal);
    }

    public AnimalsEntity findAnimal(String name) {
        return animalsDAO.findAnimal(name);
    }

    public List<AnimalsEntity> findAllAnimals() {
        return animalsDAO.findAllAnimals();
    }

    public void removeAnimal() {
        animalsDAO.removeAnimal(animal);
    }

    public void removeAllAnimals() {
        animalsDAO.removeAllAnimals();
        animalList = findAllAnimals();
    }

    public void initSelectedList() {
        selectedAnimalList = new ArrayList<AnimalsEntity>();
        for (AnimalsEntity animal: animalList) {
            if (selected.get(animal.getAnimalId())) {
                selectedAnimalList.add(animal);
            }
        }
        selected.clear();
    }

    public void moveToCart() {
        initSelectedList();
        cartBean.moveToCart(selectedAnimalList);
        cartBean.initCart();
    }


    public void deleteSelected() {
        initSelectedList();
        //animalList.removeAll(selectedAnimalList);
        animalsDAO.removeAnimals(selectedAnimalList);
        animalList = animalsDAO.findAllAnimals();
    }
}
