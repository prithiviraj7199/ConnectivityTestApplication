package com.customer.travelAgency.bookingController;


import com.customer.travelAgency.Service.CustomerService;
import com.customer.travelAgency.bookingDTO.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin("*")
@RequestMapping("api/v1/custmor")
public class BookingController{

    Logger logger=LoggerFactory.getLogger(BookingController.class);
    @Autowired
    private CustomerService customerService;
    @PostMapping( path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO custmorDTO) {
        String id = null;
        try {
            logger.info(" Customer Booking Started");
            id = customerService.saveCustomerDetails(custmorDTO);
            logger.info(" Customer Booking Details saved successfully");
        } catch (Exception ex) {
          logger.error("Customer Booking Failed with Exception {}",ex.getLocalizedMessage());
        }
        return id;
    }


    @GetMapping(path = "/getAllCustomers")
    public List<CustomerDTO> getCustomerDetails(){
        List<CustomerDTO> customer=customerService.getALLCustomer();
        logger.info(" Fetched All the Customer Details successfully");
        return customer;
    }

    @PutMapping(path = "/updateCustomers")
    public String updateCustomerDetails(@RequestBody CustomerDTO custmorDTO){
        String id = null;
        try {
            logger.info(" Customer Details update Started");
            id = customerService.updateCustomer(custmorDTO);
        logger.info(" Customer Details Updated successfully");
        } catch (Exception ex) {
            logger.error("Customer Details Updated Failed with Exception {}",ex.getLocalizedMessage());
        }
        return id;
    }

    @GetMapping(path = "/getCustomer/{customerId}")
    public CustomerDTO getCustomerDetail(@PathVariable(value = "customerId") String id){
        CustomerDTO customer=customerService.getCustomer(id);
        logger.info(" Fetched Customer Detail successfully");
        return customer;
    }

    @DeleteMapping(path = "/deleteCustomer/{id}")
    public String deleteCustomerDetails(@PathVariable(value ="id") String id){
        String customerId=customerService.deleteCustomer(id);
        logger.info(" Deleted Customer Detail successfully");
        return customerId;
    }


}
