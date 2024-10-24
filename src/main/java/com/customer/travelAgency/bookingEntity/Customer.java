package com.customer.travelAgency.bookingEntity;

import jakarta.persistence.*;

@Table(name ="customer")
@Entity
public class Customer {
    @Id
    @Column( name = "customer_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    @Column( name = "customer_Name", length = 15)
    private String customerName;
    @Column( name = "customer_address", length = 30)
    private String customerAddress;
    @Column( name = "customer_mobile", length = 10)
    private int mobile;

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public int getMobile() {
        return mobile;
    }
    public Customer(){

    }

    public Customer(int customerId, String customerName, String customerAddress, int mobile) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.mobile = mobile;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
