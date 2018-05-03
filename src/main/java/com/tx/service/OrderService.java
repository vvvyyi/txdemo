package com.tx.service;

import com.tx.model.Order;
import com.tx.model.User;
import com.tx.repository.OrderRepository;
import com.tx.repository.TaskDetailRepository;
import com.tx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by cf on 2018/5/3.
 */
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    TaskDetailRepository taskDetailRepository;
    @Autowired
    UserRepository userRepository;

    @Transactional
    public void addOrder(User user,Long amount, Long taskId){
        Order order = new Order(user,taskDetailRepository.getOne(taskId),amount, new Timestamp(Calendar.getInstance().getTimeInMillis()));
        orderRepository.save(order);
    }
}
