package com.example.minhalojinha.service.marca;

import com.example.minhalojinha.model.Marca;
import com.example.minhalojinha.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarTodos() {
        return marcaRepository.findAll();
    }

    public Marca inserir(Marca objeto) {
        objeto.setDataCriacao(new Date());
        Marca objetoNovo = marcaRepository.saveAndFlush(objeto);
        return objetoNovo;
    }

    public Marca alterar(Marca objeto) {
        objeto.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        Marca objeto = marcaRepository.findById(id).get();
        marcaRepository.delete(objeto);
    }
}
