package com.example.minhalojinha.service.marca;

import com.example.minhalojinha.model.Marca;

import java.util.List;

public interface MarcaService {
    List<Marca> buscarTodos();

    Marca inserir(Marca objeto);

    Marca alterar(Marca objeto);

    void excluir(Long id);
}
