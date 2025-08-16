package com.ims.customer.service;

import com.ims.customer.entity.Customer;
import com.ims.customer.exception.CustomException;
import com.ims.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void saveCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
        }  catch (Exception e) {
            if(e.getMessage().contains("duplicate key error")) {
                throw new CustomException("Customer with this email or mobile number already exists.");
            }
        }
    }
    public void updateCustomer(String id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            customerRepository.save(customer);
        }
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
