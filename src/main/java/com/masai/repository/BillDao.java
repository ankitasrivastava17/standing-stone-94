package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill, Integer> {

}
