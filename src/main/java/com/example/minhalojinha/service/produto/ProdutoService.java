package com.example.minhalojinha.service.produto;

import com.example.minhalojinha.model.Produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> buscarTodos();

    Produto inserir(Produto objeto);

    Produto alterar(Produto objeto);

    void excluir(Long id);
}
