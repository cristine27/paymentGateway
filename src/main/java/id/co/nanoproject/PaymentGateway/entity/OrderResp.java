package id.co.nanoproject.PaymentGateway.entity;

import lombok.Data;

@Data
public class OrderResp {
    private int id;
    private String idCust;
    private String idPaket;
    private String idPayment;
    private String status_pembayaran;
}
