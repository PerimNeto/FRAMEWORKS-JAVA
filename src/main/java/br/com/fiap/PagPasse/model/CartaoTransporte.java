package br.com.fiap.PagPasse.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tbl_cartaoTransporte")
public class CartaoTransporte {


    private Long id;

    private Long numeroCartao;

    private String tipoCartao;

    private Float saldoCartao;

    private Date dataEmissao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //------------------------------------------------------------
    public Long getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
    //------------------------------------------------------------
    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    //------------------------------------------------------------

    public Float getSaldoCartao() {
        return saldoCartao;
    }

    public void setSaldoCartao(Float saldoCartao) {
        this.saldoCartao = saldoCartao;
    }

    //------------------------------------------------------------

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaoTransporte cartaoTransporte = (CartaoTransporte) o;
        return Objects.equals(id, cartaoTransporte.id) && Objects.equals(numeroCartao, cartaoTransporte.numeroCartao) && Objects.equals(tipoCartao, cartaoTransporte.tipoCartao) && Objects.equals(saldoCartao, cartaoTransporte.saldoCartao) && Objects.equals(dataEmissao, cartaoTransporte.dataEmissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroCartao, tipoCartao, saldoCartao, dataEmissao);
    }

}
