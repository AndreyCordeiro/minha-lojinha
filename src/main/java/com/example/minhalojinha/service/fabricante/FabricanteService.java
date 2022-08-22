package com.example.minhalojinha.service.fabricante;

import com.example.minhalojinha.exceptions.BadResourceException;
import com.example.minhalojinha.exceptions.ResourceAlreadyExistsException;
import com.example.minhalojinha.exceptions.ResourceNotFoundException;
import com.example.minhalojinha.model.Fabricante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FabricanteService {
    Boolean existsById(Long id);

    Fabricante findById(Long id);

    Page<Fabricante> findAll(Pageable pageable);

    Page<Fabricante> findAllByNome(String nome, Pageable pageable);

    Fabricante saveFabricante(Fabricante fabricante) throws BadResourceException, ResourceAlreadyExistsException;

    void updateFabricante(Fabricante fabricante) throws BadResourceException, ResourceNotFoundException;

    void deleteById(Long id) throws ResourceNotFoundException;
}
