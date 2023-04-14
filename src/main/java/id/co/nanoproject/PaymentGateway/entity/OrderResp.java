package id.co.nanoproject.PaymentGateway.entity;

import lombok.Data;

@Data
public class OrderResp {
    private int order_id;
    private String namaCust;
    private String noKtp;
    private String harga;
    private String status_pembayaran;
}
