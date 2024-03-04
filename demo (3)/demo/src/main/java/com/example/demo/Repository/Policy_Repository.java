package com.example.demo.Repository;

import com.example.demo.Model.Customer_Details;
import com.example.demo.Model.Policy_Details;
import com.example.demo.Model.Policy_Details.PremiumReport;
import com.example.demo.Service.Policy_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Policy_Repository extends JpaRepository<Policy_Details ,Integer> {

    @Query("SELECT p.Policy_number AS policy_number, p.Policy_name AS policy_name, p.Policy_type AS policy_type, p.Policy_status AS policy_status, p.Policy_premium AS policy_premium FROM Policy_Details p")
    List<PremiumReport> premiumReprt();

}



