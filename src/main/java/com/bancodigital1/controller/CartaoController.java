package com.bancodigital1.controller;

import org.springframework.web.bind.annotation.*;

import com.bancodigital.model.Cartao;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    private Map<Long, Cartao> cartoes = new HashMap<>();

    @PostMapping
    public Cartao emitirCartao(@RequestBody Cartao cartao) {
        cartao.setId((long) (cartoes.size() + 1));
        cartoes.put(cartao.getId(), cartao);
        return cartao;
    }

    @GetMapping("/{id}")
    public Cartao obterCartao(@PathVariable Long id) {
        return cartoes.get(id);
    }

    @PostMapping("/{id}/pagamento")
    public String realizarPagamento(@PathVariable Long id, @RequestBody double valor) {
        Cartao cartao = cartoes.get(id);
        if (cartao != null) {
            cartao.setFatura(cartao.getFatura() - valor);
            return "Pagamento de " + valor + " realizado com sucesso!";
        }
        return "Cartão não encontrado!";
    }

    @PutMapping("/{id}/limite")
    public Cartao alterarLimite(@PathVariable Long id, @RequestBody double novoLimite) {
        Cartao cartao = cartoes.get(id);
        if (cartao != null) {
            cartao.setLimite(novoLimite);
            return cartao;
        }
        return null;
    }

    @PutMapping("/{id}/status")
    public Cartao alterarStatus(@PathVariable Long id, @RequestBody String novoStatus) {
        Cartao cartao = cartoes.get(id);
        if (cartao != null) {
            cartao.setStatus(novoStatus);
            return cartao;
        }
        return null;
    }

    
    @PutMapping("/{id}/senha")
    public Cartao alterarSenha(@PathVariable Long id, @RequestBody String novaSenha) {
        Cartao cartao = cartoes.get(id);
        if (cartao != null) {
            cartao.setSenha(novaSenha);
            return cartao;
        }
        return null;
    }

    @GetMapping("/{id}/fatura")
    public double consultarFatura(@PathVariable Long id) {
        Cartao cartao = cartoes.get(id);
        if (cartao != null) {
            return cartao.getFatura();
        }
        return -1; 
    }

    @PostMapping("/{id}/fatura/pagamento")
    public String pagarFatura(@PathVariable Long id, @RequestBody double valor) {
        Cartao cartao = cartoes.get(id);
        if (cartao != null) {
            cartao.setFatura(cartao.getFatura() - valor);
            return "Fatura paga com sucesso!";
        }
        return "Cartão não encontrado!";
    }

    @PutMapping("/{id}/limite-diario")
    public Cartao alterarLimiteDiario(@PathVariable Long id, @RequestBody double novoLimiteDiario) {
        Cartao cartao = cartoes.get(id);
        if (cartao != null) {
            cartao.setLimiteDiario(novoLimiteDiario);
            return cartao;
        }
        return null;
    }
}