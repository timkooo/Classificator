package main.mbeans;


import main.ejb.AnimalCartBean;
import main.entity.AnimalsEntity;
import main.entity.UsersEntity;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by timko_000 on 24.04.2014.
 */
@Named("cartBean")
@SessionScoped
public class CartBean implements Serializable {

    @EJB
    private AnimalCartBean animalCartBean;

    private List<AnimalsEntity> animalCartList;
    private Integer cartSize;

    @PostConstruct
    public void init() {
        if (animalCartList == null) {
            initCart();
        }
    }

    public List<AnimalsEntity> getAnimalCartList() {
        return animalCartList;
    }

    public void setAnimalCartList(List<AnimalsEntity> animalCartList) {
        this.animalCartList = animalCartList;
    }

    public Integer getCartSize() {
        return cartSize;
    }

    public void setCartSize(Integer cartSize) {
        this.cartSize = cartSize;
    }

    public void initCart() {
        animalCartList = animalCartBean.getAnimalList();
        cartSize = animalCartBean.getAnimalCartSize();
    }

    public void moveToCart(List<AnimalsEntity> list) {
        animalCartBean.addAnimalsToCart(list);
    }

    public void removeAllFromCart() {
        animalCartBean.removeAnimalsFromCart();
        initCart();
    }

    public void moveToUserCart(UsersEntity user) {

    }



}
