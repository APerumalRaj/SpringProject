package com.example.demo.Service;

//import com.example.demo.Controller.Policy_Controller;
import com.example.demo.Model.Claim_Information;
import com.example.demo.Model.Customer_Details;
import com.example.demo.Model.Policy_Details;
import com.example.demo.Model.Claim_Information.ClaimHistory;
import com.example.demo.Model.Policy_Details.PremiumReport;
import com.example.demo.Repository.Claim_Repository;
import com.example.demo.Repository.Customer_Repository;
import com.example.demo.Repository.Policy_Repository.*;
import com.example.demo.Repository.Policy_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class Policy_Service {
    @Autowired
    Policy_Repository policyRepository;


    @Autowired
    Customer_Repository customerRepository;

    @Autowired
    Claim_Repository claimRepository;


    //create Customer
    public List<Customer_Details> Create_Customer(List<Customer_Details> c){
       return customerRepository.saveAll(c);
    }

    //read customer
    public List<Customer_Details> get_Customer(Integer id) {
        if (id == null) {
            return customerRepository.findAll();
        } else {
            List<Customer_Details> c = new ArrayList<>();
            c.add(customerRepository.findById(id).orElseThrow(() -> new RuntimeException("customer not found for ID: " + id)));
            return c;
        }
    }

 //Upadte Customer
    public Customer_Details update_Customer(int id,Customer_Details p){
        Customer_Details  oldata = null;
        if (customerRepository.findById(id).isPresent()) {
            oldata = customerRepository.findById(id).get();
            oldata.setCustomer_name(p.getCustomer_name());
            oldata.setCustomer_age(p.getCustomer_age());
            oldata.setCustomer_address(p.getCustomer_address());
            oldata.setCustomer_gender(p.getCustomer_gender());
            oldata.setCustomer_martialstatus(p.getCustomer_martialstatus());
            oldata.setCustomer_occupation(p.getCustomer_occupation());
        }
        else
            throw new RuntimeException("Can`t find customer for the given id :" + id);

        if (p == null ) {
            throw new HttpMessageNotReadableException("Request body is absent ");
        }
        return customerRepository.save(oldata);
    }

    //delete customer
    public String delete_Customer(int id){
        customerRepository.deleteById(id);
        return "Succesfully customer deleted";
    }















    //create policy
    public void Create_Policy(List<Policy_Details> p){
        policyRepository.saveAll(p);
    }



    //read policy
    public List<Policy_Details> get_Policy(Integer id){
        if(id == null) {
            return policyRepository.findAll();

        }
        else{
            List<Policy_Details> c = new ArrayList<>();
            c.add(policyRepository.findById(id).orElseThrow(() -> new RuntimeException("Policy not found for ID: " + id)));
            return c;
        }
    }

    //update policy
    public Policy_Details update_Policy(int id, Policy_Details p) {
        Policy_Details  oldata = null;
        if (policyRepository.findById(id).isPresent()) {
            oldata = policyRepository.findById(id).get();
            oldata.setPolicy_name(p.getPolicy_name());
//            oldata.setPolicy_number(p.getPolicy_number());
            oldata.setPolicy_premium(p.getPolicy_premium());
//            oldata.setPolicy_status(p.getPolicy_status());
            oldata.setPolicy_type(p.getPolicy_type());
            oldata.setPolicy_start_date(p.getPolicy_start_date());
//            oldata.setPolicy_end_date(p.getPolicy_end_date());
        }
        else
            throw new RuntimeException("Can`t find policy for the given id :" + id);

        if (p == null ) {
            throw new HttpMessageNotReadableException("gyykf fgklbvxsdfghjhgfds");
        }

        return policyRepository.save(oldata);
    }
    //delete policy
    public String delete_Policy(int id){
        policyRepository.deleteById(id);
        return "Succesfully policy deleted";
    }


    public List<Claim_Information> Create_Claim(List<Claim_Information> c) {
        return claimRepository.saveAll(c);
    }
    public List<Claim_Information> get_Claim(Integer id) {
        if(id == null) {
            return claimRepository.findAll();

        }
        else{
            List<Claim_Information> c = new ArrayList<>();
            c.add(claimRepository.findById(id).orElseThrow(() -> new RuntimeException("Claim not found for ID: " + id)));
            return c;
        }
    }
    public Claim_Information update_Claim(int id, Claim_Information p) {
       Claim_Information oldata = null;
        if (claimRepository.findById(id).isPresent()) {
            oldata = claimRepository.findById(id).get();
            oldata.setClaim_date(p.getClaim_date());
            oldata.setClaim_description(p.getClaim_description());
            oldata.setAmount(p.getAmount());
        }
        else
            throw new RuntimeException("Can`t find claim for the given id :" + id);
        if (p == null ) {
            throw new HttpMessageNotReadableException("Request body is absent ");
        }
        return claimRepository.save(oldata);
    }

    public String delete_Claim(int id) {
        claimRepository.deleteById(id);
        return "Succesfully claim deleted";
    }


    public Policy_Details search_Name(String name) {
        List<Customer_Details> customerDetails = customerRepository.findAll();
        List<Policy_Details> policyDetails = policyRepository.findAll();
        int id ;
            for (Customer_Details customerDetail : customerDetails) {
                if (customerDetail.getCustomer_name().equalsIgnoreCase(name)) {
                    id = customerDetail.getCustomer_id();
                    for(Policy_Details policyDetail : policyDetails) {
                        if(policyDetail.getCustomer().getCustomer_id() == id) {
                            return  policyDetail;
                        }
                    }
                }
            }
            return  null;
        }


    public Policy_Details search_Type(String type) {
        List<Policy_Details> policyDetails = policyRepository.findAll();
        for(Policy_Details policyDetail : policyDetails) {
            if(policyDetail.getPolicy_type() .equalsIgnoreCase(type)) {
                return  policyDetail;
            }
        }
        return null;
    }

    public Policy_Details search_Number(int number) {
        List<Policy_Details> policyDetails = policyRepository.findAll();
        for(Policy_Details policyDetail : policyDetails) {
            if(policyDetail.getPolicy_number() == number) {
                return  policyDetail;
            }
        }
        return null;
    }

//    public Resource generatePolicyStatusReport(String report) {
//        List<Policy_Details> policyDetailsList = policy_status_report();
//        List<PremiumReport> premiumReportList =  policy_premium_report();
//        String fileName = "policy_status_report.txt";
//        String filePath = "D:\\Genearate reports" + fileName;
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//            for (Policy_Details policy : policyDetailsList) {
//                String line = String.format("Policy number: %d, Policy premium: %d, Status: %s",
//                        policy.getPolicy_number(), policy.getPolicy_premium(), policy.getPolicy_status());
//                writer.write(line);
//                writer.newLine();
//            }
//            return new FileSystemResource(filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public Resource generateReport(List<String> reportData, String fileName, String directoryPath) {
        String filePath = directoryPath + fileName;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : reportData) {
                writer.write(line);
                writer.newLine();
            }
            return new FileSystemResource(filePath);
        } catch (IOException e) {
            // Handle file writing exception
            e.printStackTrace();
            return null;
        }
    }
    public  List<Policy_Details> policy_status_report() {
        List<Policy_Details> p1 = new ArrayList<>();
       List<Policy_Details> policyDetails = policyRepository.findAll();
       for(Policy_Details policyDetails1 : policyDetails){
           Policy_Details p =  policyDetails1;
           Date date1 = p.getPolicy_end_date();
           Date date2 = new Date();
           long millisecondsDifference = date1.getTime() - date2.getTime();
           long years = millisecondsDifference / (1000L * 60 * 60 * 24 * 365);
           if(years > 0)
               p.setPolicy_status("Active");
           else if (years < 0)
               p.setPolicy_status("Expired");
           else
               p.setPolicy_status("Pending");
           p1.add(p);
       }
        List<Policy_Details> policyDetailsList = p1;
        List<String> reportData = new ArrayList<>();
        for (Policy_Details policy : policyDetailsList) {
            String line = String.format("Policy Number: %d, Policy Name: %s, Policy Type: %s, Policy Status: %s, Policy Premium: %d, Start Date: %s, End Date: %s",
                    policy.getPolicy_number(), policy.getPolicy_name(), policy.getPolicy_type(), policy.getPolicy_status(), policy.getPolicy_premium(), policy.getPolicy_start_date(), policy.getPolicy_end_date());
            reportData.add(line);
        }
        String fileName = "policy_status_report.txt"; // Name of the report file
        String directoryPath = "D:\\Genearate reports\\"; // Directory path for the report

        generateReport(reportData, fileName, directoryPath);
        return  p1 ;

    }

    public List<PremiumReport> policy_premium_report() {
        List<PremiumReport> premiumReports = policyRepository.premiumReprt();
        List<String> reportData = new ArrayList<>();
        for (PremiumReport premiumReport : premiumReports) {
            String line = String.format("Policy Number: %d, Policy Name: %s, Policy Type: %s, Policy Status: %s, Policy Premium: %d",
                    premiumReport.getPolicy_number(), premiumReport.getPolicy_name(), premiumReport.getPolicy_type(), premiumReport.getPolicy_status(), premiumReport.getPolicy_premium());
            reportData.add(line);
            reportData.add(line);
        }
        String fileName = "policy_premium_report.txt"; // Name of the report file
        String directoryPath = "D:\\Genearate reports\\"; // Directory path for the report

        generateReport(reportData, fileName, directoryPath);
       return  premiumReports;
    }

    public  List<Claim_Information> claimHistory() {
        List<Claim_Information> claimhistory = claimRepository.claimhistory();
        List<String> reportData = new ArrayList<>();
        for (Claim_Information claim : claimhistory) {
//            String line = String.format("Customer ID: %d, Customer Name: %s, Customer Age: %d, Policy Number: %d, Policy Name: %s, Policy Premium: %d, Claim ID: %d, Claim Description: %s, Claim Amount: %d",
//                    claim.getCustomer_id(), claim.getCustomer_name(), claim.getCustomer_age(), claim.getPolicy_number(), claim.getPolicy_name(), claim.getPolicy_premium(), claim.getClaim_id(), claim.getClaim_description(), claim.getAmount());
            String line = String.format("Claim ID: %d, Policy Number: %d, Claim Date: %s, Claim Description: %s, Amount: %d",
                    claim.getClaim_id(), claim.getPolicyDetails().getPolicy_number(), claim.getClaim_date(), claim.getClaim_description(), claim.getAmount());
            reportData.add(line);
            reportData.add(line);
        }
        String fileName = "claim_history_report.txt"; // Name of the report file
        String directoryPath = "D:\\Genearate reports\\"; // Directory path for the report

        generateReport(reportData, fileName, directoryPath);
            return claimhistory;
    }


    public List<Policy_Details.modify> difference() {
        List<Policy_Details> policyDetails = policyRepository.findAll() ;
        List<Policy_Details.modify> m = null;
        int diff = 0;
        for(Policy_Details policyDetails1 : policyDetails) {
        for (Policy_Details.Policyfrequency frequency : Policy_Details.Policyfrequency.values()) {
            if (policyDetails1.getFreq().equals(frequency.name())) {
                int value = frequency.getValue();
                diff = policyDetails1.getPolicy_premium()/ value;
            }
        }
        }
        return m;
    }
}
