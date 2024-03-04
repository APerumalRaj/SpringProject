package com.example.demo.Controller;

import com.example.demo.Model.Claim_Information;
import com.example.demo.Model.Customer_Details;
import com.example.demo.Model.Policy_Details;
//import com.example.demo.Model.premiumRepor;
import com.example.demo.Model.Claim_Information.ClaimHistory;
import com.example.demo.Model.Policy_Details.PremiumReport;
import com.example.demo.Service.Policy_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
//@RequestMapping("/policy")
public class Policy_Controller {
    @Autowired
    Policy_Service policyService;

    @PostMapping("/addcustomer")
    public List<Customer_Details> addCustomerDetails(@RequestBody List<Customer_Details> c){
        return policyService.Create_Customer(c);
    }

    @GetMapping("/getcustomer")
    public List<Customer_Details> getCustomerDetails(@RequestParam(required = false)  Integer id ){
        return policyService.get_Customer(id);
    }

    @GetMapping("/updatecustomer/{id}")
    public Customer_Details updatePolicyDetails(@PathVariable int id,@RequestBody Customer_Details p){
        return policyService.update_Customer(id,p);
    }

    @PostMapping("/deletecustomer/{id}")
    public String deleteCustomerDetails(@PathVariable int id){
        return policyService.delete_Customer(id);
    }










    @PostMapping("/addpolicy")
    public String addPolicyDetails(@RequestBody List<Policy_Details> p){
        policyService.Create_Policy(p);
        return "Successfuly Added";
    }



    @GetMapping("/getpolicy")
    public List<Policy_Details> getPolicyDetails(@RequestParam(required = false) Integer id ){
        return policyService.get_Policy(id);
    }

    @GetMapping("/updatepolicy/{id}")
    public Policy_Details updatePolicyDetails(@PathVariable int id,@RequestBody Policy_Details p){
        return policyService.update_Policy(id,p);
    }

    @PostMapping("/deletepolicy/{id}")
    public String deletePolicydetails(@PathVariable int id){
        return policyService.delete_Policy(id);
    }







    @PostMapping("/addclaim")
    public List<Claim_Information> addClaimDetails(@RequestBody List<Claim_Information> c){
        return policyService.Create_Claim(c);
    }

    @GetMapping("/getclaim")
    public List<Claim_Information> getClaimDetails(@RequestParam int id ){
        return policyService.get_Claim(id);
    }

    @GetMapping("/updatecclaim/{id}")
    public Claim_Information updateClaimDetails(@PathVariable int id,@RequestBody Claim_Information p){
        return policyService.update_Claim(id,p);
    }

    @PostMapping("/deleteclaim/{id}")
    public String deleteClaimDetails(@PathVariable int id){
        return policyService.delete_Claim(id);
    }


    @PostMapping("/searchbyname/{name}")
    public Policy_Details searcByName(@PathVariable String name){
        return policyService.search_Name(name);
    }

    @PostMapping("/searchbypolicytype/{type}")
    public Policy_Details searcByType(@PathVariable String type){
        return policyService.search_Type(type);
    }

    @PostMapping("/searchbypolicytypenumber/{number}")
    public Policy_Details searcByNumber(@PathVariable int number){
        return policyService.search_Number(number);
    }


@GetMapping("/policystatus")
public  List<Policy_Details> policyStatusReport(){
    return policyService.policy_status_report();
}

    @GetMapping("/policypremium")
    public  List<PremiumReport> policyPremiumReport(){
        return policyService.policy_premium_report();
    }

    @GetMapping("/claimhistory")
    public  List<Claim_Information> policyClaimReport(){
        return policyService.claimHistory();
    }

    @PostMapping("/difference")
    public List<Policy_Details.modify> insurance_time(){
        return policyService.difference();
    }

}
//
//@GetMapping("/generate/{report}")
//public Resource generateStatusReport(@PathVariable String report){
//    return policyService.generatePolicyStatusReport(report);
//    @GetMapping("/table")
//    public List<TableRow> showTable(Model model) {
//        List<TableRow> data = new ArrayList<>();
//        data.add(new TableRow("Value 1A", "Value 1B", "Value 1C"));
//        data.add(new TableRow("Value 2A", "Value 2B", "Value 2C"));
//        data.add(new TableRow("Value 3A", "Value 3B", "Value 3C"));
//        model.addAttribute("data", data);
//        return data; // Thymeleaf template name without extension
//    }

    // Define TableRow class (represents data for each row)
//    private static class TableRow {
//        private String column1;
//        private String column2;
//        private String column3;
//
//        public TableRow(String column1, String column2, String column3) {
//            this.column1 = column1;
//            this.column2 = column2;
//            this.column3 = column3;
//        }
//    }


