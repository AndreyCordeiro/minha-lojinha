package com.example.minhalojinha.repository;

import com.example.minhalojinha.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
