package br.com.fiap.PagPasse.service;

import br.com.fiap.PagPasse.dto.CartaoTransporteDTO;
import br.com.fiap.PagPasse.model.CartaoTransporte;
import br.com.fiap.PagPasse.repository.CartaoTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoTransporteService {

    @Autowired
    private CartaoTransporteRepository cartaoTransporteRepository;

    public CartaoTransporteDTO adicionar(CartaoTransporteDTO dto) {
        CartaoTransporte cartao = new CartaoTransporte();
        cartao.setNumeroCartao(dto.numeroCartao());
        cartao.setTipoCartao(dto.tipoCartao());
        cartao.setSaldoCartao(dto.saldoCartao());
        cartao.setDataEmissao(dto.dataEmissao());
        CartaoTransporte salvo = cartaoTransporteRepository.save(cartao);
        return new CartaoTransporteDTO(salvo.getId(), salvo.getNumeroCartao(), salvo.getTipoCartao(), salvo.getSaldoCartao(), salvo.getDataEmissao());
    }

    public Optional<CartaoTransporteDTO> buscarPorId(Long id) {
        return cartaoTransporteRepository.findById(id)
                .map(cartao -> new CartaoTransporteDTO(cartao.getId(), cartao.getNumeroCartao(), cartao.getTipoCartao(), cartao.getSaldoCartao(), cartao.getDataEmissao()));
    }

    public CartaoTransporteDTO atualizar(Long id, CartaoTransporteDTO dto) {
        CartaoTransporte cartao = cartaoTransporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado!"));
        cartao.setNumeroCartao(dto.numeroCartao());
        cartao.setTipoCartao(dto.tipoCartao());
        cartao.setSaldoCartao(dto.saldoCartao());
        cartao.setDataEmissao(dto.dataEmissao());
        CartaoTransporte atualizado = cartaoTransporteRepository.save(cartao);
        return new CartaoTransporteDTO(atualizado.getId(), atualizado.getNumeroCartao(), atualizado.getTipoCartao(), atualizado.getSaldoCartao(), atualizado.getDataEmissao());
    }

    public void excluir(Long id) {
        cartaoTransporteRepository.deleteById(id);
    }
}
