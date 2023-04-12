package id.co.nanoproject.PaymentGateway.repo;

import id.co.nanoproject.PaymentGateway.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerById(Integer id);

    Customer findCustomerByNoKtp(String noKtp);
}
