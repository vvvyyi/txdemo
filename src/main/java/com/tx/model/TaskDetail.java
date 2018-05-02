package com.tx.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2018/4/29.
 */
@Entity
public class TaskDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //任务所在地
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="city_id",referencedColumnName = "id")
    private DictCity dictCity;
    //标题
    private String title;
    private String description;
    private long amount;
    private TaskStatus status;
    private Timestamp addTime;
    private Timestamp orderTime;
    private Timestamp finishTime;
}
enum TaskStatus{
    NORMAL("未处理"),PROCESSIOG("处理中"),FINISH("已完成"),INVALID("失效");
    private String title;
    TaskStatus(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
