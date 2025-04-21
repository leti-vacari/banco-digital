package com.bancodigital1.controller;

import com.bancodigital.model.Conta;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @PostMapping
    public Conta criarConta(@RequestBody Conta conta) {
        return conta;
    }

    @GetMapping("/{id}")
    public Conta obterConta(@PathVariable Long id) {
        return new Conta(id, 1000.00);
    }

    @GetMapping("/{id}/saldo")
    public double consultarSaldo(@PathVariable Long id) {
        return 1000.00;
    }
}