package com.example.minhalojinha.util;

import com.example.minhalojinha.dto.VendaDTO;
import com.example.minhalojinha.entity.Venda;
import com.example.minhalojinha.exceptions.InfoException;
import org.springframework.http.HttpStatus;

public class UtilVenda {
    public static Boolean validarVenda(Venda venda) throws InfoException {
        if (venda.getUsuario() == null) {
            throw new InfoException("MESSAGE.USUARIO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (venda.getCliente() == null) {
            throw new InfoException("MESSAGE.CLIENTE_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (venda.getItensVenda() == null || venda.getItensVenda().size() == 0) {
            throw new InfoException("MESSAGE.ITEM_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }

    public static VendaDTO converteVenda(Venda venda) {
        return VendaDTO.builder()
                .itensVenda(UtilItensVenda.converterListaItensVenda(venda.getItensVenda()))
                .build();
    }
}
