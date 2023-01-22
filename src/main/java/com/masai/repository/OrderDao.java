package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

}
