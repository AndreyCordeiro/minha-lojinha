package com.example.minhalojinha.service.venda;

import com.example.minhalojinha.exceptions.BadResourceException;
import com.example.minhalojinha.exceptions.ResourceAlreadyExistsException;
import com.example.minhalojinha.exceptions.ResourceNotFoundException;
import com.example.minhalojinha.model.Venda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VendaService {
    Boolean existsById(Long id);

    Venda findById(Long id);

    Page<Venda> findAll(Pageable pageable);

    Venda salvarVenda(Venda venda) throws BadResourceException, ResourceAlreadyExistsException;

    void deleteById(Long id) throws ResourceNotFoundException;

    Long count();
}
