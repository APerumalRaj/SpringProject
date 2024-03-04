package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;



@Entity
@Data

public class Policy_Details {

//    @Autowired
//    Policy_Details po_de;
    @Id
    @Column(nullable = false)
    private  int Policy_number ;
    @Column(nullable = false)
    private  String Policy_name;
    @Column(nullable = false)
    private  String Policy_type;

    private  String Policy_status;
    @Column(nullable = false)
    private   int Policy_premium;
    @Temporal(TemporalType.DATE)
    private Date Policy_start_date;
    @Temporal(TemporalType.DATE)
    private Date Policy_end_date;

    private String freq ;

    private int value ;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public   enum  Policyfrequency{
        ANNUAL(1),
        QUARTELY(4),
        MONTHLY1(2);


        private final int  value ;
        Policyfrequency(int i) {
            this.value = i;
        }

            public int getValue() {
                return value;
            }
        }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "Customer_id")
    private Customer_Details customer;

    public int getPolicy_number() {
        return Policy_number;
    }

    public void setPolicy_number(int policy_number) {
        Policy_number = policy_number;
    }

    public String getPolicy_name() {
        return Policy_name;
    }

    public void setPolicy_name(String policy_name) {
        Policy_name = policy_name;
    }

    public String getPolicy_type() {
        return Policy_type;
    }

    public void setPolicy_type(String policy_type) {
        Policy_type = policy_type;
    }

    public String getPolicy_status() {
        return Policy_status;
    }

    public String setPolicy_status(String policy_status) {
            this.Policy_status = policy_status;
            return this.Policy_status;
    }

    public int getPolicy_premium() {
        return Policy_premium;
    }

    public void setPolicy_premium(int policy_premium) {
        Policy_premium = policy_premium;
    }



    public Customer_Details getCustomer() {
        return customer;
    }

    public void setCustomer(Customer_Details customer) {
        this.customer = customer;
    }

    public Date getPolicy_start_date() {
        return Policy_start_date;
    }

    public void setPolicy_start_date(Date policy_start_date) {
        Policy_start_date = policy_start_date;
    }

    public Date getPolicy_end_date() {
        return Policy_end_date;
    }

    public void setPolicy_end_date(Date policy_end_date) {
        Policy_end_date = policy_end_date;
    }


    public interface PremiumReport {
        int getPolicy_number();
        String getPolicy_name();
        String getPolicy_type();
        String getPolicy_status();
        int getPolicy_premium();
    }
    public interface modify {
        int getPolicy_number();

        String getPolicy_name();
        int getPolicy_premium();
        int getFreq();

        int getValue();

    }
}
