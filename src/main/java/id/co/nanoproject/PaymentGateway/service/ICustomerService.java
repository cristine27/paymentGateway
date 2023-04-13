package id.co.nanoproject.PaymentGateway.service;

import id.co.nanoproject.PaymentGateway.model.Customer;

import java.util.List;

public interface ICustomerService {
    void insert(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);

    Customer findCustomerById(Integer id);
    Customer findCustomerByNoKtp(String noKtp);

    List<Customer> allCustomers();
}
