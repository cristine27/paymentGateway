package id.co.nanoproject.PaymentGateway.service;

import id.co.nanoproject.PaymentGateway.model.Customer;
import id.co.nanoproject.PaymentGateway.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void insert(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.deleteById(customer.getId());
    }

    @Override
    public Customer findCustomer(Customer customer) {
        return customerRepository.findCustomerById(customer.getId());
    }

    @Override
    public List<Customer> allCustomers() {
        return customerRepository.findAll();
    }
}
