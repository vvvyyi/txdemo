package com.tx.model;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @ManyToOne
    @JoinColumn(name="task_detail_id",referencedColumnName = "id")
    private TaskDetail taskDetail;

    //订单成交价格
    private long realAmount;

    private Timestamp addTime;
    private OrderStatus orderStatus;


    public Order(User user, TaskDetail taskDetail, long realAmount, Timestamp addTime) {
        this.user = user;
        this.taskDetail = taskDetail;
        this.realAmount = realAmount;
        this.addTime = addTime;
        this.orderStatus = OrderStatus.NORMAL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskDetail getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(TaskDetail taskDetail) {
        this.taskDetail = taskDetail;
    }

    public long getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(long realAmount) {
        this.realAmount = realAmount;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }
}
enum OrderStatus{
    NORMAL("未处理"),PROCESSIOG("处理中"),FINISH("已完成"),INVALID("失效");
    private String title;
    OrderStatus(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
