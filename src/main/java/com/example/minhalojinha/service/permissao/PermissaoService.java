package com.example.minhalojinha.service.permissao;

import com.example.minhalojinha.model.Permissao;

import java.util.List;

public interface PermissaoService {
    List<Permissao> buscarTodos();

    Permissao inserir(Permissao objeto);

    Permissao alterar(Permissao objeto);

    void excluir(Long id);
}
