package id.co.nanoproject.PaymentGateway.controller;

import id.co.nanoproject.PaymentGateway.entity.OrderResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/tnt")
public class OrderRestTemplateController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${resourcesURL}")
    String resourcesURL;

    @GetMapping("/order/{id}")
    public @ResponseBody OrderResp getOrder(@PathVariable("id") int id) {
        OrderResp orderResp = restTemplate.getForObject(resourcesURL + "/" + id, OrderResp.class);
        return orderResp;
    }
}
