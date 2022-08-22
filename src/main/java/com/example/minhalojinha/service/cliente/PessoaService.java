package com.example.minhalojinha.service.cliente;

import com.example.minhalojinha.model.Pessoa;

import java.util.List;

public interface PessoaService {
    List<Pessoa> buscarTodos();

    Pessoa inserir(Pessoa objeto);

    Pessoa alterar(Pessoa objeto);

    void excluir(Long id);
}
