package jpabook.model.entity;

import jpabook.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "ORDERS")
@Data
public class Order {
    @Id @GeneratedValue
    @Column (name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "orderId")
    private List<OrderItem> orderItemList = new ArrayList<OrderItem>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void setMember (Member member) {
        if (this.member != null) {
            this.member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItemList.add(orderItem);
        orderItem.setOrder(this);
    }
}
