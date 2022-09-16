package com.example.minhalojinha.util;

import com.example.minhalojinha.dto.ItensVendaDTO;
import com.example.minhalojinha.entity.ItensVenda;

import java.util.ArrayList;
import java.util.List;

public class UtilItensVenda {
    public static List<ItensVendaDTO> converterListaItensVenda(List<ItensVenda> itensVendaList) {
        List<ItensVendaDTO> itensVendaDTOList = new ArrayList<>();

        for (ItensVenda itensVenda : itensVendaList) {
            itensVendaDTOList.add(converteItensVenda(itensVenda));
        }
        return itensVendaDTOList;
    }

    public static ItensVendaDTO converteItensVenda(ItensVenda itensVenda) {
        return ItensVendaDTO.builder()
                .idVenda(itensVenda.getVenda().getId())
                .quantidade(itensVenda.getQuantidade())
                .valorUnitario(itensVenda.getValorUnitario())
                .produto(UtilProduto.converterProduto(itensVenda.getProduto()))
                .build();
    }
}
