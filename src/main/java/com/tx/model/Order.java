package com.tx.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/4/29.
 */
@Entity
@Table(name="user_order")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    //订单成交价格
    private long realAmount;

}
