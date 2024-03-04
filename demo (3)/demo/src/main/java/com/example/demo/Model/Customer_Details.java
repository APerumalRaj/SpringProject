package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer_Details {
    @Id
    private int Customer_id;
    @Column(nullable = false)
    private String Customer_name;
    @Column(nullable = false)
    private int Customer_age;
    private String Customer_gender;
//    private String Customer_nationality;
    private String Customer_martialstatus;
    private String Customer_occupation;
    private String Customer_address;

    public int getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(int customer_id) {
        Customer_id = customer_id;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public int getCustomer_age() {
        return Customer_age;
    }

    public void setCustomer_age(int customer_age) {
        Customer_age = customer_age;
    }

    public String getCustomer_gender() {
        return Customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        Customer_gender = customer_gender;
    }

    public String getCustomer_martialstatus() {
        return Customer_martialstatus;
    }

    public void setCustomer_martialstatus(String customer_martialstatus) {
        Customer_martialstatus = customer_martialstatus;
    }

    public String getCustomer_occupation() {
        return Customer_occupation;
    }

    public void setCustomer_occupation(String customer_occupation) {
        Customer_occupation = customer_occupation;
    }

    public String getCustomer_address() {
        return Customer_address;
    }

    public void setCustomer_address(String customer_address) {
        Customer_address = customer_address;
    }
}
