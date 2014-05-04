package main.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by timko_000 on 04.05.2014.
 */
@Entity
@Table(name = "carts", schema = "public", catalog = "ebank")
public class CartsEntity {
    private Integer cartUser;
    private Integer cartId;
    private Collection<AnimalsEntity> animalsesByCartId;
    private UsersEntity usersByCartUser;
    private Collection<CartsAnimalsEntity> cartsAnimalsesByCartId;

    @Basic
    @Column(name = "cart_user")
    public Integer getCartUser() {
        return cartUser;
    }

    public void setCartUser(Integer cartUser) {
        this.cartUser = cartUser;
    }

    @Id
    @Column(name = "cart_id")
    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartsEntity that = (CartsEntity) o;

        if (cartId != null ? !cartId.equals(that.cartId) : that.cartId != null) return false;
        if (cartUser != null ? !cartUser.equals(that.cartUser) : that.cartUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartUser != null ? cartUser.hashCode() : 0;
        result = 31 * result + (cartId != null ? cartId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cartsByAnimalCart")
    public Collection<AnimalsEntity> getAnimalsesByCartId() {
        return animalsesByCartId;
    }

    public void setAnimalsesByCartId(Collection<AnimalsEntity> animalsesByCartId) {
        this.animalsesByCartId = animalsesByCartId;
    }

    @ManyToOne
    @JoinColumn(name = "cart_user", referencedColumnName = "user_id")
    public UsersEntity getUsersByCartUser() {
        return usersByCartUser;
    }

    public void setUsersByCartUser(UsersEntity usersByCartUser) {
        this.usersByCartUser = usersByCartUser;
    }

    @OneToMany(mappedBy = "cartsByCaranimCart")
    public Collection<CartsAnimalsEntity> getCartsAnimalsesByCartId() {
        return cartsAnimalsesByCartId;
    }

    public void setCartsAnimalsesByCartId(Collection<CartsAnimalsEntity> cartsAnimalsesByCartId) {
        this.cartsAnimalsesByCartId = cartsAnimalsesByCartId;
    }
}
