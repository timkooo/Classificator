package main.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by timko_000 on 04.05.2014.
 */
public class CartsAnimalsEntityPK implements Serializable {
    private Integer caranimCart;
    private Integer caranimAnimal;

    @Column(name = "caranim_cart")
    @Id
    public Integer getCaranimCart() {
        return caranimCart;
    }

    public void setCaranimCart(Integer caranimCart) {
        this.caranimCart = caranimCart;
    }

    @Column(name = "caranim_animal")
    @Id
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

        CartsAnimalsEntityPK that = (CartsAnimalsEntityPK) o;

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
}
