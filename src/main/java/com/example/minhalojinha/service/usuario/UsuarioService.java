package com.example.minhalojinha.service.usuario;

import com.example.minhalojinha.dto.UsuarioDTO;
import com.example.minhalojinha.entity.Usuario;
import com.example.minhalojinha.exceptions.InfoException;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> buscarTodos();

    UsuarioDTO inserir(Usuario usuario, String tipoUsuario) throws InfoException;

    UsuarioDTO alterar(Long id, Usuario usuario, String tipoUsuario) throws InfoException;

    void excluir(Long id) throws InfoException;
}
