package com.example.minhalojinha.util;

import com.example.minhalojinha.dto.FabricanteDTO;
import com.example.minhalojinha.entity.Fabricante;
import com.example.minhalojinha.exceptions.InfoException;
import org.springframework.http.HttpStatus;

public class UtilFabricante {
    public static Boolean validarFabricante(Fabricante fabricante) throws InfoException {
        if (fabricante.getNome() == null || fabricante.getNome().equals("")) {
            throw new InfoException("MESSAGE.NOME_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }

    public static FabricanteDTO converteFabricante(Fabricante fabricante) {
        return FabricanteDTO.builder()
                .nome(fabricante.getNome())
                .build();
    }
}
