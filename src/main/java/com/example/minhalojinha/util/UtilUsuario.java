package com.example.minhalojinha.util;

import com.example.minhalojinha.dto.UsuarioDTO;
import com.example.minhalojinha.entity.Usuario;
import com.example.minhalojinha.exceptions.InfoException;
import org.springframework.http.HttpStatus;

public class UtilUsuario {
    public static Boolean validarUsuario(Usuario usuario) throws InfoException {
        if (usuario.getNome() == null || usuario.getNome().equals("")) {
            throw new InfoException("MESSAGE.NOME_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getDocumento() == null || usuario.getDocumento().equals("")) {
            throw new InfoException("MESSAGE.CPF_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getEndereco() == null || usuario.getEndereco().equals("")) {
            throw new InfoException("MESSAGE.ENDERECO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getCep() == null || usuario.getCep().equals("")) {
            throw new InfoException("MESSAGE.CEP_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getEmail() == null || usuario.getEmail().equals("")) {
            throw new InfoException("MESSAGE.EMAIL_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (usuario.getSenha() == null || usuario.getSenha().equals("")) {
            throw new InfoException("MESSAGE.SENHA_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }

    public static UsuarioDTO converteUsuario(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .documento(usuario.getDocumento())
                .endereco(usuario.getEndereco())
                .tipoUsuario(usuario.getTipoUsuario() != null ? usuario.getTipoUsuario().toString() : null)
                .cep(usuario.getCep())
                .email(usuario.getEmail())
                .build();
    }
}
