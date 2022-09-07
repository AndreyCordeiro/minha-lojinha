package com.example.minhalojinha.service.itensVenda;

import com.example.minhalojinha.entity.ItensVenda;
import com.example.minhalojinha.exceptions.InfoException;

public interface ItensVendaService {
    ItensVenda inserirItensVenda(ItensVenda itensVenda);

    void excluirItensVenda(Long id) throws InfoException;
}
