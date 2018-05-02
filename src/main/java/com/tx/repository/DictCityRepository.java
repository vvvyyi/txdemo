package com.tx.repository;

import com.tx.model.DictCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DictCityRepository extends JpaRepository<DictCity,Long> {
    List<DictCity> findByNameStartsWith(@Param("name") String name);
    List<DictCity> findByParentId(@Param("parentId") int parentId);
}
