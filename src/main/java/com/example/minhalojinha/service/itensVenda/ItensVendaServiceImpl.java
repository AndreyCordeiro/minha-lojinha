package com.example.minhalojinha.service.itensVenda;

import com.example.minhalojinha.model.ItensVenda;
import com.example.minhalojinha.repository.ItensVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItensVendaServiceImpl {
    @Autowired
    private ItensVendaRepository itensVendaRepository;

    protected ItensVenda salvarItensVenda(ItensVenda itensVenda) {
        return itensVendaRepository.save(itensVenda);
    }
}