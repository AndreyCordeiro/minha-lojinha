package com.example.minhalojinha.service.itensVenda;

import com.example.minhalojinha.entity.ItensVenda;
import com.example.minhalojinha.exceptions.InfoException;
import com.example.minhalojinha.repository.ItensVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItensVendaServiceImpl implements ItensVendaService {
    @Autowired
    private ItensVendaRepository itensVendaRepository;

    @Override
    public ItensVenda inserirItensVenda(ItensVenda itensVenda) {
        return itensVendaRepository.save(itensVenda);
    }

    @Override
    public void excluirItensVenda(Long id) throws InfoException {
        List<ItensVenda> itensVendas = itensVendaRepository.findItensVendasByVendaId(id);

        if (itensVendas != null && itensVendas.size() > 0) {
            itensVendaRepository.deleteAll(itensVendas);
        } else {
            throw new InfoException("Itens da Venda não encontrados", HttpStatus.NOT_FOUND);
        }
    }
}
