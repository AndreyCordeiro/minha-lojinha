package com.example.minhalojinha.service.estado;

import com.example.minhalojinha.model.Estado;

import java.util.List;

public interface EstadoService {
    List<Estado> buscarTodos();

    Estado inserir(Estado objeto);

    Estado alterar(Estado objeto);

    void excluir(Long id);
}
