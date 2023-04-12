package id.co.nanoproject.PaymentGateway.service;

import id.co.nanoproject.PaymentGateway.model.Payment;

import java.util.List;

public interface IPaymentService {
    void insert(Payment payment);

    void update(Payment payment);

    void delete(Payment payment);

    List<Payment> allPayment();

    Payment findPayment(Payment payment);

    Payment findPaymentByIdOrderTransaction(Integer idOrderTransaction);

    List<Payment> findPaymentByIdCust(Integer idCust);
}
