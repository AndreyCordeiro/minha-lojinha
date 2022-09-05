package com.example.minhalojinha.util;

import com.example.minhalojinha.dto.CategoriaDTO;
import com.example.minhalojinha.entity.Categoria;
import com.example.minhalojinha.exceptions.InfoException;
import org.springframework.http.HttpStatus;

public class UtilCategoria {
    public static Boolean validarCategoria(Categoria categoria) throws InfoException {
        if (categoria.getNome() == null || categoria.getNome().equals("")) {
            throw new InfoException("MESSAGE.NOME_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }

    public static CategoriaDTO converteCategoria(Categoria categoria) {
        return CategoriaDTO.builder()
                .nome(categoria.getNome())
                .build();
    }
}
