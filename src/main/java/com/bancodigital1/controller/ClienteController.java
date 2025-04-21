package com.bancodigital1.controller;
import com.bancodigital.model.Cliente;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return cliente;
    }

    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable Long id) {
        return new Cliente(id, "João Silva", "joao.silva@example.com", "12345678900");
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return cliente;
    }

    @DeleteMapping("/{id}")
    public String removerCliente(@PathVariable Long id) {
        return "Cliente com ID " + id + " foi removido.";
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return Arrays.asList(
            new Cliente(1L, "João Silva", "joao.silva@example.com", "12345678900"),
            new Cliente(2L, "Maria Oliveira", "maria.oliveira@example.com", "98765432100")
        );
    }
}
