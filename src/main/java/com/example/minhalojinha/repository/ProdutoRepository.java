package com.example.minhalojinha.repository;

import com.example.minhalojinha.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}