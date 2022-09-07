package com.example.minhalojinha.service.venda;

import com.example.minhalojinha.dto.VendaDTO;
import com.example.minhalojinha.entity.Venda;
import com.example.minhalojinha.exceptions.InfoException;

import java.util.List;

public interface VendaService {
    List<VendaDTO> buscarTodos();

    VendaDTO inserir(Venda venda) throws InfoException;

    void excluir(Long id) throws InfoException;
}
