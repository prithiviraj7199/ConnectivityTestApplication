package com.customer.travelAgency.Service;

import com.customer.travelAgency.bookingDTO.CustomerDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomerDetails(CustomerDTO customerDTO);

    List<CustomerDTO> getALLCustomer();
    String updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomer(String id);

    String deleteCustomer(String id);
}
