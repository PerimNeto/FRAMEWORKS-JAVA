package br.com.fiap.PagPasse.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tbl_extrato")
public class Extrato {


    private Long id;

    private Float valorTarifa;

    private Date dataPagamento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //------------------------------------------------------------
    public Float getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(Float valorTarifa) {
        this.valorTarifa = valorTarifa;
    }
    //------------------------------------------------------------
    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Extrato extrato = (Extrato) o;
        return Objects.equals(id, extrato.id) && Objects.equals(valorTarifa, extrato.valorTarifa) && Objects.equals(dataPagamento, extrato.dataPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valorTarifa, dataPagamento);
    }

}
