package br.com.fiap.PagPasse.controller;

import br.com.fiap.PagPasse.dto.CartaoTransporteDTO;
import br.com.fiap.PagPasse.service.CartaoTransporteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cartao-transporte")
public class CartaoTransporteController {

    @Autowired
    private CartaoTransporteService cartaoTransporteService;

    @PostMapping("/adicionar")
    public ResponseEntity<CartaoTransporteDTO> adicionar(@Valid @RequestBody CartaoTransporteDTO dto) {
        return ResponseEntity.ok(cartaoTransporteService.adicionar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartaoTransporteDTO> buscarPorId(@PathVariable Long id) {
        Optional<CartaoTransporteDTO> cartaoOpt = cartaoTransporteService.buscarPorId(id);
        return cartaoOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartaoTransporteDTO> atualizar(@PathVariable Long id, @Valid @RequestBody CartaoTransporteDTO dto) {
        return ResponseEntity.ok(cartaoTransporteService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        cartaoTransporteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
