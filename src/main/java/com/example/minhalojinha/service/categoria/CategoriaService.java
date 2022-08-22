package com.example.minhalojinha.service.categoria;

import com.example.minhalojinha.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> buscarTodos();

    Categoria inserir(Categoria objeto);

    Categoria alterar(Categoria objeto);

    void excluir(Long id);
}
