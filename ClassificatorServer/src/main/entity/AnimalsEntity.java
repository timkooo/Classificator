package main.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by timko_000 on 04.05.2014.
 */
@Entity
@Table(name = "animals", schema = "public", catalog = "ebank")
public class AnimalsEntity {
    private String animalName;
    private Integer animalAge;
    private Integer animalId;
    private Double animalSum;
    private Integer animalOrder;
    private String animalReview;
    private byte[] animalImg;
    private Integer animalCart;
    private CartsEntity cartsByAnimalCart;
    private OrdersEntity ordersByAnimalOrder;
    private Collection<AnimalsOrdersEntity> animalsOrdersesByAnimalId;
    private Collection<CartsAnimalsEntity> cartsAnimalsesByAnimalId;

    @Basic
    @Column(name = "animal_name")
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Basic
    @Column(name = "animal_age")
    public Integer getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(Integer animalAge) {
        this.animalAge = animalAge;
    }

    @Id
    @Column(name = "animal_id")
    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    @Basic
    @Column(name = "animal_sum")
    public Double getAnimalSum() {
        return animalSum;
    }

    public void setAnimalSum(Double animalSum) {
        this.animalSum = animalSum;
    }

    @Basic
    @Column(name = "animal_order")
    public Integer getAnimalOrder() {
        return animalOrder;
    }

    public void setAnimalOrder(Integer animalOrder) {
        this.animalOrder = animalOrder;
    }

    @Basic
    @Column(name = "animal_review")
    public String getAnimalReview() {
        return animalReview;
    }

    public void setAnimalReview(String animalReview) {
        this.animalReview = animalReview;
    }

    @Basic
    @Column(name = "animal_img")
    public byte[] getAnimalImg() {
        return animalImg;
    }

    public void setAnimalImg(byte[] animalImg) {
        this.animalImg = animalImg;
    }

    @Basic
    @Column(name = "animal_cart")
    public Integer getAnimalCart() {
        return animalCart;
    }

    public void setAnimalCart(Integer animalCart) {
        this.animalCart = animalCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalsEntity entity = (AnimalsEntity) o;

        if (animalAge != null ? !animalAge.equals(entity.animalAge) : entity.animalAge != null) return false;
        if (animalCart != null ? !animalCart.equals(entity.animalCart) : entity.animalCart != null) return false;
        if (animalId != null ? !animalId.equals(entity.animalId) : entity.animalId != null) return false;
        if (!Arrays.equals(animalImg, entity.animalImg)) return false;
        if (animalName != null ? !animalName.equals(entity.animalName) : entity.animalName != null) return false;
        if (animalOrder != null ? !animalOrder.equals(entity.animalOrder) : entity.animalOrder != null) return false;
        if (animalReview != null ? !animalReview.equals(entity.animalReview) : entity.animalReview != null)
            return false;
        if (animalSum != null ? !animalSum.equals(entity.animalSum) : entity.animalSum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = animalName != null ? animalName.hashCode() : 0;
        result = 31 * result + (animalAge != null ? animalAge.hashCode() : 0);
        result = 31 * result + (animalId != null ? animalId.hashCode() : 0);
        result = 31 * result + (animalSum != null ? animalSum.hashCode() : 0);
        result = 31 * result + (animalOrder != null ? animalOrder.hashCode() : 0);
        result = 31 * result + (animalReview != null ? animalReview.hashCode() : 0);
        result = 31 * result + (animalImg != null ? Arrays.hashCode(animalImg) : 0);
        result = 31 * result + (animalCart != null ? animalCart.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "animal_cart", referencedColumnName = "cart_id")
    public CartsEntity getCartsByAnimalCart() {
        return cartsByAnimalCart;
    }

    public void setCartsByAnimalCart(CartsEntity cartsByAnimalCart) {
        this.cartsByAnimalCart = cartsByAnimalCart;
    }

    @ManyToOne
    @JoinColumn(name = "animal_order", referencedColumnName = "order_id")
    public OrdersEntity getOrdersByAnimalOrder() {
        return ordersByAnimalOrder;
    }

    public void setOrdersByAnimalOrder(OrdersEntity ordersByAnimalOrder) {
        this.ordersByAnimalOrder = ordersByAnimalOrder;
    }

    @OneToMany(mappedBy = "animalsByAniordAnimal")
    public Collection<AnimalsOrdersEntity> getAnimalsOrdersesByAnimalId() {
        return animalsOrdersesByAnimalId;
    }

    public void setAnimalsOrdersesByAnimalId(Collection<AnimalsOrdersEntity> animalsOrdersesByAnimalId) {
        this.animalsOrdersesByAnimalId = animalsOrdersesByAnimalId;
    }

    @OneToMany(mappedBy = "animalsByCaranimAnimal")
    public Collection<CartsAnimalsEntity> getCartsAnimalsesByAnimalId() {
        return cartsAnimalsesByAnimalId;
    }

    public void setCartsAnimalsesByAnimalId(Collection<CartsAnimalsEntity> cartsAnimalsesByAnimalId) {
        this.cartsAnimalsesByAnimalId = cartsAnimalsesByAnimalId;
    }
}
