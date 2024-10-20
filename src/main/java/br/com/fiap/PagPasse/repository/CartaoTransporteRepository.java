package br.com.fiap.PagPasse.repository;

import br.com.fiap.PagPasse.model.CartaoTransporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CartaoTransporteRepository  extends JpaRepository<CartaoTransporte, Long> {

    public Optional<CartaoTransporte> findById(Long id);

    public Optional<CartaoTransporte> findByNumeroCartao(Long numeroCartao);

    public List<CartaoTransporte> findBySaldoCartao(Float saldoCartao);

    public Optional<CartaoTransporte> findByTipoCartao(String tipoCartao);

    public Optional<CartaoTransporte> findByDataEmissaoBetween(LocalDate dataEmissao);

}

//perguntar sobre Between se é necessario, quando usar
// Perguntar se tem que fazer realmente todos os repository (todas as columas)

