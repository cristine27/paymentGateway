package id.co.nanoproject.PaymentGateway.controller;

import id.co.nanoproject.PaymentGateway.model.Payment;
import id.co.nanoproject.PaymentGateway.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    IPaymentService paymentService;

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
    public String addPayment(@RequestParam("idCust") int idCust,
                             @RequestParam("idOrderTransaction") int idOrderTransaction,
                             @RequestParam("total") int total) {
        Payment payment = new Payment();
        payment.setId(0);
        payment.setIdCust(idCust);
        payment.setIdOrderTransaction(idOrderTransaction);
        payment.setTotal(total);
        payment.setStatusPembayaran("WAITING");
        paymentService.insert(payment);

        return "redirect:/payment/all";
    }

    @GetMapping("/update")
    public String updatePaymentStatus(@RequestParam("id") int id,
                                      @RequestParam("statuspembayaran") String statusPembayaran) {
        Payment payment = new Payment();
        payment.setId(id);
        payment.setStatusPembayaran(statusPembayaran);
        paymentService.update(payment);

        return "redirect:/payment/all";
    }
}
