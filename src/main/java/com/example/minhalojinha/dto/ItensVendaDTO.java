package com.example.minhalojinha.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItensVendaDTO {
    private Double quantidade;
    private Double valorUnitario;
    private Long idVenda;
    private ProdutoDTO produto;
}
