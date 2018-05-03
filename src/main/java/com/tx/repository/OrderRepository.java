package com.tx.repository;

import com.tx.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cf on 2018/5/3.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
