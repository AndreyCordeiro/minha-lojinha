package com.example.minhalojinha.controller;

import com.example.minhalojinha.dto.ClienteDTO;
import com.example.minhalojinha.entity.Cliente;
import com.example.minhalojinha.exceptions.InfoException;
import com.example.minhalojinha.service.cliente.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
@Tag(name = "Cliente", description = "API de Cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    @Operation(summary = "Buscar Clientes", description = "Busca todos os Clientes cadastrados")
    public List<ClienteDTO> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar Cliente", description = "Cadastra um Cliente")
    public ClienteDTO inserir(@RequestBody Cliente cliente) throws InfoException {
        return clienteService.inserir(cliente);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizar Cliente", description = "Altera um cliente em específico")
    public ClienteDTO alterar(@PathVariable("id") Long id, @RequestBody Cliente cliente) throws InfoException {
        return clienteService.alterar(id, cliente);
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar Cliente", description = "Exclui um Cliente em específico")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws InfoException {
        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
