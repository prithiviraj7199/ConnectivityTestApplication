package com.customer.travelAgency.Service;

import com.customer.travelAgency.bookingDTO.CustomerDTO;
import com.customer.travelAgency.bookingEntity.Customer;
import com.customer.travelAgency.bookingRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String saveCustomerDetails(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setCustomerAddress(customerDTO.getCustomerAddress());
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setMobile(customerDTO.getMobile());
        customerRepository.save(customer);
        return String.valueOf(customer.getCustomerId());
    }

    @Override
    public List<CustomerDTO> getALLCustomer() {
        List<Customer> customerList = new ArrayList<>();
        customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setCustomerName(customer.getCustomerName());
            customerDTO.setCustomerAddress(customer.getCustomerAddress());
            customerDTO.setMobile(customer.getMobile());
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        Customer customer = null;
        customer = customerRepository.findById(customerDTO.getCustomerId()).get();
        if (customer != null) {
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddress(customerDTO.getCustomerAddress());
            customer.setMobile(customerDTO.getMobile());
            customerRepository.save(customer);
        }
        return String.valueOf(customerDTO.getCustomerId());
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        CustomerDTO customerDTO = new CustomerDTO();
        Customer customer = customerRepository.findById(Integer.parseInt(id)).get();
        if (customer != null) {
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setCustomerName(customer.getCustomerName());
            customerDTO.setCustomerAddress(customer.getCustomerAddress());
            customerDTO.setMobile(customer.getMobile());
        }
        return customerDTO;
    }

    @Override
    public String deleteCustomer(String id) {
        customerRepository.deleteById(Integer.parseInt(id));
        return String.valueOf(id);
    }
}
