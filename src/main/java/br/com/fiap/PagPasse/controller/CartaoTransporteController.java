package br.com.fiap.PagPasse.controller;

import br.com.fiap.PagPasse.service.CartaoTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cartao-transporte")
public class CartaoTransporteController {

    @Autowired
    private CartaoTransporteService cartaoTransporteService;

    @PostMapping("/pagar-tarifa/{id}")
    public ResponseEntity<String> pagarTarifa(@PathVariable Long id, @RequestParam Float valorTarifa) {
        try {
            cartaoTransporteService.pagarTarifa(id, valorTarifa);
            return ResponseEntity.ok("Pagamento de tarifa realizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
