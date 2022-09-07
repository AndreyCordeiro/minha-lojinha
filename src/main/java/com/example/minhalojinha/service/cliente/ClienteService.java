package com.example.minhalojinha.service.cliente;


import com.example.minhalojinha.dto.ClienteDTO;
import com.example.minhalojinha.entity.Cliente;
import com.example.minhalojinha.exceptions.InfoException;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> buscarTodos();

    ClienteDTO inserir(Cliente cliente) throws InfoException;

    ClienteDTO alterar(Long id, Cliente cliente) throws InfoException;

    void excluir(Long id) throws InfoException;
}
