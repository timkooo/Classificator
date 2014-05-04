package main.entity;

import javax.persistence.*;

/**
 * Created by timko_000 on 04.05.2014.
 */
@Entity
@Table(name = "animals_orders", schema = "public", catalog = "ebank")
@IdClass(AnimalsOrdersEntityPK.class)
public class AnimalsOrdersEntity {
    private Integer aniordAnimal;
    private Integer aniordOrder;
    private AnimalsEntity animalsByAniordAnimal;
    private OrdersEntity ordersByAniordOrder;

    @Id
    @Column(name = "aniord_animal")
    public Integer getAniordAnimal() {
        return aniordAnimal;
    }

    public void setAniordAnimal(Integer aniordAnimal) {
        this.aniordAnimal = aniordAnimal;
    }

    @Id
    @Column(name = "aniord_order")
    public Integer getAniordOrder() {
        return aniordOrder;
    }

    public void setAniordOrder(Integer aniordOrder) {
        this.aniordOrder = aniordOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalsOrdersEntity that = (AnimalsOrdersEntity) o;

        if (aniordAnimal != null ? !aniordAnimal.equals(that.aniordAnimal) : that.aniordAnimal != null) return false;
        if (aniordOrder != null ? !aniordOrder.equals(that.aniordOrder) : that.aniordOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aniordAnimal != null ? aniordAnimal.hashCode() : 0;
        result = 31 * result + (aniordOrder != null ? aniordOrder.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "aniord_animal", referencedColumnName = "animal_id", nullable = false)
    public AnimalsEntity getAnimalsByAniordAnimal() {
        return animalsByAniordAnimal;
    }

    public void setAnimalsByAniordAnimal(AnimalsEntity animalsByAniordAnimal) {
        this.animalsByAniordAnimal = animalsByAniordAnimal;
    }

    @ManyToOne
    @JoinColumn(name = "aniord_order", referencedColumnName = "order_id", nullable = false)
    public OrdersEntity getOrdersByAniordOrder() {
        return ordersByAniordOrder;
    }

    public void setOrdersByAniordOrder(OrdersEntity ordersByAniordOrder) {
        this.ordersByAniordOrder = ordersByAniordOrder;
    }
}
