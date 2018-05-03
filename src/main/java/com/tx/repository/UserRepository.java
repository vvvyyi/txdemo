package com.tx.repository;

import com.tx.model.DictCity;
import com.tx.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameStartsWith(@Param("name") String name);

}
