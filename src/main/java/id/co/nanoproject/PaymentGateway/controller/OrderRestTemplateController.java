package id.co.nanoproject.PaymentGateway.controller;

import id.co.nanoproject.PaymentGateway.entity.OrderResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

public class OrderRestTemplateController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${resourcesURL}")
    String resourcesURL;

    @GetMapping("/order")
    public @ResponseBody OrderResp getOrder(int id) {
        OrderResp orderResp = restTemplate.getForObject(resourcesURL + "/" + id, OrderResp.class);
        return orderResp;
    }
}
