package com.example.minhalojinha.service.cargo;

import com.example.minhalojinha.exceptions.BadResourceException;
import com.example.minhalojinha.exceptions.ResourceAlreadyExistsException;
import com.example.minhalojinha.exceptions.ResourceNotFoundException;
import com.example.minhalojinha.model.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CargoService {
    Boolean existsById(Long id);

    Cargo findById(Long id);

    Page<Cargo> findAll(Pageable pageable);

    Page<Cargo> findAllByNome(String nome, Pageable pageable);

    Cargo saveCargo(Cargo cargo) throws BadResourceException, ResourceAlreadyExistsException;

    void updateCargo(Cargo cargo) throws BadResourceException, ResourceNotFoundException;

    void deleteById(Long id) throws ResourceNotFoundException;

    Long count();
}
