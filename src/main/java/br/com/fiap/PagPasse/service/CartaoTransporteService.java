package br.com.fiap.PagPasse.service;

import br.com.fiap.PagPasse.model.CartaoTransporte;
import br.com.fiap.PagPasse.repository.CartaoTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoTransporteService {

    @Autowired
    private CartaoTransporteRepository cartaoTransporteRepository;

    public void pagarTarifa(Long id, Float valorTarifa) {
        Optional<CartaoTransporte> cartao = cartaoTransporteRepository.findById(id);

        if (cartao.isPresent()) {
            CartaoTransporte cartaoTransporte = cartao.get();
            // Lógica de pagar tarifa (restar saldo)
            if (cartaoTransporte.getSaldoCartao() >= valorTarifa) {
                cartaoTransporte.setSaldoCartao(cartaoTransporte.getSaldoCartao() - valorTarifa);
                cartaoTransporteRepository.save(cartaoTransporte);
            } else {
                throw new RuntimeException("Saldo insuficiente.");
            }
        } else {
            throw new RuntimeException("Cartão não encontrado.");
        }
    }
}