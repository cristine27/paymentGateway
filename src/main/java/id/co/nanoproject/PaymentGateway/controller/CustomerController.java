package id.co.nanoproject.PaymentGateway.controller;

import id.co.nanoproject.PaymentGateway.model.Customer;
import id.co.nanoproject.PaymentGateway.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/all")
    public @ResponseBody List<Customer> getAll() {
        return customerService.allCustomers();
    }

    @GetMapping("/find")
    public @ResponseBody Customer getCustomerById(@RequestParam("id") int id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/add")
    public String addCustomer(@RequestBody Customer customer) {
        customerService.insert(customer);

        return "redirect:/customer/all";
    }

    @GetMapping("/update")
    public String updatePaymentStatus(@RequestBody Customer customer) {
        customerService.update(customer);

        return "redirect:/customer/all";
    }
}
