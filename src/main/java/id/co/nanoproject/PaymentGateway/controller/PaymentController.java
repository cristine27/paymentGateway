package id.co.nanoproject.PaymentGateway.controller;

import id.co.nanoproject.PaymentGateway.model.Customer;
import id.co.nanoproject.PaymentGateway.model.Payment;
import id.co.nanoproject.PaymentGateway.service.ICustomerService;
import id.co.nanoproject.PaymentGateway.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    IPaymentService paymentService;
    @Autowired
    ICustomerService customerService;

    @GetMapping("/all")
    public @ResponseBody List<Payment> getAll() {
        return paymentService.allPayment();
    }

    @GetMapping("/find/order-transaction")
    public @ResponseBody Payment getPaymentByIdOrderTransaction(@RequestParam("id") int idOrderTransaction) {
        return paymentService.findPaymentByIdOrderTransaction(idOrderTransaction);
    }

    @GetMapping("/find/customer")
    public @ResponseBody List<Payment> getPaymentByIdCust(@RequestParam("id") int idCust) {
        return paymentService.findPaymentByIdCust(idCust);
    }

    @GetMapping("/add")
    public Integer addPayment(@RequestParam("noKtp") String noKtp,
                             @RequestParam("idOrderTransaction") int idOrderTransaction,
                             @RequestParam("total") int total) throws Exception {
        Customer customer = new Customer();
        try {
            customer = customerService.findCustomerByNoKtp(noKtp);
        } catch (Exception e) {
            throw new Exception("Customer Not Found in Payment Gateway");
        }
        Payment payment = new Payment();
        payment.setId(0);
        payment.setIdCust(customer.getId());
        payment.setIdOrderTransaction(idOrderTransaction);
        payment.setTotal(total);
        payment.setStatusPembayaran("WAITING");
        paymentService.insert(payment);

        return payment.getId();
    }

    @GetMapping("/update")
    public String updatePaymentStatus(@RequestParam("id") int id,
                                      @RequestParam("statusPembayaran") String statusPembayaran) {
        Payment payment = new Payment();
        payment.setId(id);
        payment.setStatusPembayaran(statusPembayaran);
        paymentService.update(payment);

        return "redirect:/payment/all";
    }

    //@PostMapping("/pay")
}
