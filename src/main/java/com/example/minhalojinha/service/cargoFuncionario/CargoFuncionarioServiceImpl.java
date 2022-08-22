package com.example.minhalojinha.service.cargoFuncionario;

import com.example.minhalojinha.model.CargoFuncionario;
import com.example.minhalojinha.repository.CargoFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoFuncionarioServiceImpl {
    @Autowired
    private CargoFuncionarioRepository cargoFuncionarioRepository;

    protected CargoFuncionario saveCargoFuncionario(CargoFuncionario cargoFuncionario) {
        return cargoFuncionarioRepository.save(cargoFuncionario);
    }
}