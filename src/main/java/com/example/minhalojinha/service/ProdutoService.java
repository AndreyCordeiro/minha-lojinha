package com.example.minhalojinha.service;

import com.example.minhalojinha.exceptions.BadResourceException;
import com.example.minhalojinha.exceptions.ResourceAlreadyExistsException;
import com.example.minhalojinha.exceptions.ResourceNotFoundException;
import com.example.minhalojinha.model.entity.Produto;
import com.example.minhalojinha.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.module.ResolutionException;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    private Boolean existsById(Long id) {
        return produtoRepository.existsById(id);
    }

    public Produto findById(Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);

        if (produto == null) {
            throw new ResolutionException("O produto " + id + " não foi encontrado");
        } else {
            return produto;
        }
    }

    public Page<Produto> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Page<Produto> findAllByNome(String nome, Pageable pageable) {
        return produtoRepository.findByNome(nome, pageable);
    }

    public Produto saveProduto(Produto produto) throws BadResourceException, ResourceAlreadyExistsException {
        if (!StringUtils.isEmpty(produto.getNome())) {
            if (produto.getId() != null && existsById(produto.getId())) {
                throw new ResourceAlreadyExistsException("O produto " + produto.getId() + " não foi encontrado");
            }
            return produtoRepository.save(produto);
        } else {
            BadResourceException badResourceException = new BadResourceException("Erro ao salvar o produto");
            badResourceException.addErrorMessage("Produto está vazio ou é nulo");
            throw badResourceException;
        }
    }

    public void updateProduto(Produto produto) throws BadResourceException, ResourceNotFoundException {
        if (!StringUtils.isEmpty(produto.getNome())) {
            if (!existsById(produto.getId())) {
                throw new ResourceNotFoundException("O produto " + produto.getId() + " não foi encontrado");
            }
            produtoRepository.save(produto);
        } else {
            BadResourceException badResourceException = new BadResourceException("Erro ao salvar produto");
            badResourceException.addErrorMessage("Produto está vazio ou é nulo");
            throw badResourceException;
        }
    }

    public void deleteById(Long id) throws ResourceNotFoundException {
        if (!existsById(id)) {
            throw new ResourceNotFoundException("O produto " + id + " não foi encontrado");
        } else {
            produtoRepository.deleteById(id);
        }
    }

    public Long count() {
        return produtoRepository.count();
    }
}
