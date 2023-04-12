package id.co.nanoproject.PaymentGateway.service;

import id.co.nanoproject.PaymentGateway.model.Payment;
import id.co.nanoproject.PaymentGateway.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public void insert(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void update(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void delete(Payment payment) {
        paymentRepository.deleteById(payment.getId());
    }

    @Override
    public List<Payment> allPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findPayment(Payment payment) {
        return paymentRepository.findPaymentById(payment.getId());
    }

    @Override
    public Payment findPaymentByIdOrderTransaction(Integer idOrderTransaction) {
        return paymentRepository.findPaymentByIdOrderTransaction(idOrderTransaction);
    }

    @Override
    public List<Payment> findPaymentByIdCust(Integer idCust) {
        return paymentRepository.findPaymentByIdCust(idCust);
    }
}
