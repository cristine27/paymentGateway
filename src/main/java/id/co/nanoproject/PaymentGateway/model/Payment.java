package id.co.nanoproject.PaymentGateway.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "id_cust")
    private int idCust;
    @Column(name = "id_order_transaction")
    private int idOrderTransaction;
    @Column(name = "total")
    private int total;
    @Column(name = "status_pembayaran")
    private String statusPembayaran;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCust() {
        return idCust;
    }

    public void setIdCust(int idCust) {
        this.idCust = idCust;
    }

    public int getIdOrderTransaction() {
        return idOrderTransaction;
    }

    public void setIdOrderTransaction(int idOrderTransaction) {
        this.idOrderTransaction = idOrderTransaction;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }
}
