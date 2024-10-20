package br.com.fiap.PagPasse.service;


import br.com.fiap.PagPasse.model.CartaoTransporte;
import br.com.fiap.PagPasse.repository.CartaoTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoTransporteService {

    @Autowired
    private CartaoTransporteRepository cartaoTransporteRepository;

    //-----------------------------------------------------------------------------

    public CartaoTransporte gravar(CartaoTransporte cartaoTransporte){
        return cartaoTransporteRepository.save(cartaoTransporte);
    }

    //-----------------------------------------------------------------------------

    public Optional<CartaoTransporte> buscarPorId(Long id){

        Optional<CartaoTransporte> cartaoTransporteOptional = cartaoTransporteRepository.findById(id);

        if (cartaoTransporteOptional.isPresent()){
            return Optional.of(cartaoTransporteOptional.get());
        } else {
            throw new RuntimeException("Cartão não encontrado!");
        }
    }

//--------------------------------------------------------------------------------

    public CartaoTransporte atualizar(CartaoTransporte cartaoTransporte){
        Optional<CartaoTransporte> cartaoTransporteOptional = cartaoTransporteRepository.findById(cartaoTransporte.getId());

        if(cartaoTransporteOptional.isPresent()){
            return cartaoTransporteRepository.save(cartaoTransporte);
        } else {
            throw new RuntimeException("Cartão não encontrado!");
        }
    }

    //-------------------------------------------------------------

    public void pagarTarifa(Long idCartao, Float valorTarifa) {
        // Buscar o cartão pelo ID
        CartaoTransporte cartaoTransporte = buscarPorId(idCartao)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado!"));

        // Verificar se o saldo é suficiente
        if (cartaoTransporte.getSaldoCartao() < valorTarifa) {
            throw new RuntimeException("Saldo insuficiente!");
        }

        // Subtrair o valor da tarifa do saldo
        cartaoTransporte.setSaldoCartao(cartaoTransporte.getSaldoCartao() - valorTarifa);

        // Atualizar o saldo no banco de dados
        cartaoTransporteRepository.save(cartaoTransporte);
    }

}



// pra atualizar o saldo precisa importar a recarga no cartaoTransporteService,
// ou isso se faz na packge Controller
//tem que colocar o valor da tarifa?
