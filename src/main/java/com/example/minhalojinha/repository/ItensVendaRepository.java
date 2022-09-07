package com.example.minhalojinha.repository;

import com.example.minhalojinha.entity.ItensVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItensVendaRepository extends JpaRepository<ItensVenda, Long> {
    List<ItensVenda> findItensVendasByVendaId(Long id);
}
