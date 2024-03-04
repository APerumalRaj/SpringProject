package com.example.demo.Repository;

import com.example.demo.Model.Claim_Information;
import com.example.demo.Model.Policy_Details;
import com.example.demo.Model.Claim_Information.ClaimHistory;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Claim_Repository extends JpaRepository<Claim_Information,Integer> {

//    @Query("Select c.Customer_id , c.Customer_name,c.Customer_age , p.Policy_number,p.Policy_name,p.Policy_premium ,cl.Claim_id,cl.Claim_description,cl.amount from Customer_Details c , Policy_Details p ,Claim_Information cl  where c.Customer_id = p.customer.Customer_id and p.Policy_number= cl.policyDetails.Policy_number")
//    List<ClaimHistory> claimhistory();

    @Query("Select cl from Claim_Information cl")
    List<Claim_Information> claimhistory();
}
