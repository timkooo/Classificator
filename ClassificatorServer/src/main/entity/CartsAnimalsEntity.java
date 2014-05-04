package main.entity;

import javax.persistence.*;

/**
 * Created by timko_000 on 04.05.2014.
 */
@Entity
@Table(name = "carts_animals", schema = "public", catalog = "ebank")
@IdClass(CartsAnimalsEntityPK.class)
public class CartsAnimalsEntity {
    private Integer caranimCart;
    private Integer caranimAnimal;
    private AnimalsEntity animalsByCaranimAnimal;
    private CartsEntity cartsByCaranimCart;

    @Id
    @Column(name = "caranim_cart")
    public Integer getCaranimCart() {
        return caranimCart;
    }

    public void setCaranimCart(Integer caranimCart) {
        this.caranimCart = caranimCart;
    }

    @Id
    @Column(name = "caranim_animal")
    public Integer getCaranimAnimal() {
        return caranimAnimal;
    }

    public void setCaranimAnimal(Integer caranimAnimal) {
        this.caranimAnimal = caranimAnimal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartsAnimalsEntity that = (CartsAnimalsEntity) o;

        if (caranimAnimal != null ? !caranimAnimal.equals(that.caranimAnimal) : that.caranimAnimal != null)
            return false;
        if (caranimCart != null ? !caranimCart.equals(that.caranimCart) : that.caranimCart != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = caranimCart != null ? caranimCart.hashCode() : 0;
        result = 31 * result + (caranimAnimal != null ? caranimAnimal.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "caranim_animal", referencedColumnName = "animal_id", nullable = false)
    public AnimalsEntity getAnimalsByCaranimAnimal() {
        return animalsByCaranimAnimal;
    }

    public void setAnimalsByCaranimAnimal(AnimalsEntity animalsByCaranimAnimal) {
        this.animalsByCaranimAnimal = animalsByCaranimAnimal;
    }

    @ManyToOne
    @JoinColumn(name = "caranim_cart", referencedColumnName = "cart_id", nullable = false)
    public CartsEntity getCartsByCaranimCart() {
        return cartsByCaranimCart;
    }

    public void setCartsByCaranimCart(CartsEntity cartsByCaranimCart) {
        this.cartsByCaranimCart = cartsByCaranimCart;
    }
}
