package Donosos.donosos.DonosoPedido;

import java.math.BigDecimal;
import java.sql.Date;

import Donosos.donosos.Donosocliente.DonosoCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DonosoPedido 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date fechadelpedido;
    private Boolean estadopedido;
    private BigDecimal total;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getFechadelpedido() {
        return fechadelpedido;
    }
    public void setFechadelpedido(Date fechadelpedido) {
        this.fechadelpedido = fechadelpedido;
    }
    public Boolean getEstadopedido() {
        return estadopedido;
    }
    public void setEstadopedido(Boolean estadopedido) {
        this.estadopedido = estadopedido;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @ManyToOne
    private DonosoCliente donosoCliente;
}