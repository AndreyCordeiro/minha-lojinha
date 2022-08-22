package com.example.minhalojinha.service.cidade;

import com.example.minhalojinha.model.Cidade;

import java.util.List;

public interface CidadeService {
    List<Cidade> buscarTodos();

    Cidade inserir(Cidade objeto);

    Cidade alterar(Cidade objeto);

    void excluir(Long id);
}
