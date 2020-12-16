package jpabook.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn( name = "ORDER_ID")
    private Order order;

    private int orderPrice;
    private int count;

}
