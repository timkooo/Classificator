package main.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by timko_000 on 04.05.2014.
 */
@Entity
@Table(name = "orders", schema = "public", catalog = "ebank")
public class OrdersEntity {
    private Date orderDate;
    private Double orderSum;
    private Integer orderUser;
    private Integer orderId;
    private Collection<AnimalsEntity> animalsesByOrderId;
    private Collection<AnimalsOrdersEntity> animalsOrdersesByOrderId;
    private UsersEntity usersByOrderUser;

    @Basic
    @Column(name = "order_date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "order_sum")
    public Double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Double orderSum) {
        this.orderSum = orderSum;
    }

    @Basic
    @Column(name = "order_user")
    public Integer getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(Integer orderUser) {
        this.orderUser = orderUser;
    }

    @Id
    @Column(name = "order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (orderSum != null ? !orderSum.equals(that.orderSum) : that.orderSum != null) return false;
        if (orderUser != null ? !orderUser.equals(that.orderUser) : that.orderUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderDate != null ? orderDate.hashCode() : 0;
        result = 31 * result + (orderSum != null ? orderSum.hashCode() : 0);
        result = 31 * result + (orderUser != null ? orderUser.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByAnimalOrder")
    public Collection<AnimalsEntity> getAnimalsesByOrderId() {
        return animalsesByOrderId;
    }

    public void setAnimalsesByOrderId(Collection<AnimalsEntity> animalsesByOrderId) {
        this.animalsesByOrderId = animalsesByOrderId;
    }

    @OneToMany(mappedBy = "ordersByAniordOrder")
    public Collection<AnimalsOrdersEntity> getAnimalsOrdersesByOrderId() {
        return animalsOrdersesByOrderId;
    }

    public void setAnimalsOrdersesByOrderId(Collection<AnimalsOrdersEntity> animalsOrdersesByOrderId) {
        this.animalsOrdersesByOrderId = animalsOrdersesByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "order_user", referencedColumnName = "user_id")
    public UsersEntity getUsersByOrderUser() {
        return usersByOrderUser;
    }

    public void setUsersByOrderUser(UsersEntity usersByOrderUser) {
        this.usersByOrderUser = usersByOrderUser;
    }
}
