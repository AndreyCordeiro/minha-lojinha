package com.example.minhalojinha.repository;

import com.example.minhalojinha.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query(value = "select a from Categoria a where a.nome like %?1%")
    Page<Categoria> findByNome(String nome, Pageable page);

    Page<Categoria> findAll(Pageable page);
}
