package com.example.demo.Repository;

import com.example.demo.Model.Customer_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Customer_Repository extends JpaRepository<Customer_Details,Integer> {


}
