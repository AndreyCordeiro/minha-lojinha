package com.example.minhalojinha.service.venda;

import com.example.minhalojinha.exceptions.BadResourceException;
import com.example.minhalojinha.exceptions.ResourceAlreadyExistsException;
import com.example.minhalojinha.exceptions.ResourceNotFoundException;
import com.example.minhalojinha.model.ItensVenda;
import com.example.minhalojinha.model.Venda;
import com.example.minhalojinha.repository.VendaRepository;
import com.example.minhalojinha.service.itensVenda.ItensVendaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
public class VendaServiceImpl extends ItensVendaServiceImpl implements VendaService {
    public static final Logger logger = LoggerFactory.getLogger(VendaServiceImpl.class);

    @Autowired
    private VendaRepository vendaRepository;

    public Boolean existsById(Long id) {
        return vendaRepository.existsById(id);
    }

    public Venda findById(Long id) {
        Venda venda = vendaRepository.findById(id).orElse(null);

        if (venda == null) {
            throw new ResolutionException("A venda " + id + " não foi encontrada");
        } else {
            return venda;
        }
    }

    public Page<Venda> findAll(Pageable pageable) {
        return vendaRepository.findAll(pageable);
    }

    public Venda salvarVenda(Venda venda) throws BadResourceException, ResourceAlreadyExistsException {
        if (venda != null) {
            Venda vendaSalva = vendaRepository.save(venda);
            logger.info("Venda " + venda.getId() + " salva com sucesso!");

            for (ItensVenda itens : vendaSalva.getItensVenda()) {
                itens.setVenda(vendaSalva);
                salvarItensVenda(itens);
            }
            logger.info("O(s) item(ns) da venda " + venda.getId() + " foi(ram) salvo(s) com sucesso!");
        } else {
            BadResourceException badResourceException = new BadResourceException("Erro ao realizar venda");
            badResourceException.addErrorMessage("Venda está vazia ou é nula");
            throw badResourceException;
        }
        return venda;
    }

    public void deleteById(Long id) throws ResourceNotFoundException {
        if (!existsById(id)) {
            throw new ResourceNotFoundException("A venda " + id + " não foi encontrada");
        } else {
            vendaRepository.deleteById(id);
        }
    }

    public Long count() {
        return vendaRepository.count();
    }
}