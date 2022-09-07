package com.example.minhalojinha.service.categoria;


import com.example.minhalojinha.entity.Categoria;
import com.example.minhalojinha.exceptions.InfoException;

import java.util.List;

public interface CategoriaService {
    List<Categoria> buscarTodos();

    Categoria inserir(Categoria objeto) throws InfoException;

    Categoria alterar(Long id, Categoria objeto) throws InfoException;

    void excluir(Long id) throws InfoException;
}
