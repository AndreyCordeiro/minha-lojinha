package com.example.minhalojinha.util;

import com.example.minhalojinha.dto.ProdutoDTO;
import com.example.minhalojinha.entity.Produto;
import com.example.minhalojinha.exceptions.InfoException;
import org.springframework.http.HttpStatus;

public class UtilProduto {
    public static Boolean validarProduto(Produto produto) throws InfoException {
        if (produto.getDescricao() == null || produto.getDescricao().equals("")) {
            throw new InfoException("MESSAGE.DESCRICAO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getValorCusto() == null) {
            throw new InfoException("MESSAGE.VALOR_CUSTO_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getValorVenda() == null) {
            throw new InfoException("MESSAGE.VALOR_VENDA_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getFabricante() == null) {
            throw new InfoException("MESSAGE.MARCA_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        if (produto.getCategoria() == null) {
            throw new InfoException("MESSAGE.CATEGORIA_REQUIRED", HttpStatus.BAD_REQUEST);
        }
        return true;
    }

    public static ProdutoDTO converterProduto(Produto produto) {
        return ProdutoDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .descricao(produto.getDescricao())
                .valorCusto(produto.getValorCusto())
                .valorVenda(produto.getValorVenda())
                .fabricante(produto.getFabricante() != null ? UtilFabricante.converteFabricante(produto.getFabricante()) : null)
                .categoria(produto.getCategoria() != null ? UtilCategoria.converteCategoria(produto.getCategoria()) : null)
                .build();
    }
}
