package main.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by timko_000 on 04.05.2014.
 */
public class AnimalsOrdersEntityPK implements Serializable {
    private Integer aniordAnimal;
    private Integer aniordOrder;

    @Column(name = "aniord_animal")
    @Id
    public Integer getAniordAnimal() {
        return aniordAnimal;
    }

    public void setAniordAnimal(Integer aniordAnimal) {
        this.aniordAnimal = aniordAnimal;
    }

    @Column(name = "aniord_order")
    @Id
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

        AnimalsOrdersEntityPK that = (AnimalsOrdersEntityPK) o;

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
}
