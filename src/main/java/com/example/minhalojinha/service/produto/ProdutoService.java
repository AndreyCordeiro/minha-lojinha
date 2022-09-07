package com.example.minhalojinha.service.produto;

import com.example.minhalojinha.entity.Produto;
import com.example.minhalojinha.exceptions.InfoException;

import java.util.List;

public interface ProdutoService {
    List<Produto> buscarTodos();

    Produto inserir(Produto objeto) throws InfoException;

    Produto alterar(Long id, Produto objeto) throws InfoException;

    void excluir(Long id) throws InfoException;
}
