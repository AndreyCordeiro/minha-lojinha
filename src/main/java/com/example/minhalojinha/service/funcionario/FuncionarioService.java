package com.example.minhalojinha.service.funcionario;

import com.example.minhalojinha.exceptions.BadResourceException;
import com.example.minhalojinha.exceptions.ResourceAlreadyExistsException;
import com.example.minhalojinha.exceptions.ResourceNotFoundException;
import com.example.minhalojinha.model.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FuncionarioService {
    Boolean existsById(Long id);

    Funcionario findById(Long id);

    Page<Funcionario> findAll(Pageable pageable);

    Page<Funcionario> findAllByNome(String nome, Pageable pageable);

    Funcionario saveFuncionario(Funcionario funcionario) throws BadResourceException, ResourceAlreadyExistsException;

    void updateFuncionario(Funcionario funcionario) throws BadResourceException, ResourceNotFoundException;

    void deleteById(Long id) throws ResourceNotFoundException;

    Long count();
}
