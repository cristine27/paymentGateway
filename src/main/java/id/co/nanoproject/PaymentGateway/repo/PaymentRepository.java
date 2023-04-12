package id.co.nanoproject.PaymentGateway.repo;

import id.co.nanoproject.PaymentGateway.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findPaymentById(Integer id);
    List<Payment> findPaymentByIdCust(Integer idCust);
    Payment findPaymentByIdOrderTransaction(Integer idOrderTransaction);
}
