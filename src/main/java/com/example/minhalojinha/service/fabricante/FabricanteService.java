package com.example.minhalojinha.service.fabricante;

import com.example.minhalojinha.entity.Fabricante;
import com.example.minhalojinha.exceptions.InfoException;

import java.util.List;

public interface FabricanteService {
    List<Fabricante> buscarTodos();

    Fabricante inserir(Fabricante objeto) throws InfoException;

    Fabricante alterar(Long id, Fabricante objeto) throws InfoException;

    void excluir(Long id) throws InfoException;
}
