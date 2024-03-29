package com.example.minhalojinha.service.venda;

import com.example.minhalojinha.dto.VendaDTO;
import com.example.minhalojinha.entity.ItensVenda;
import com.example.minhalojinha.entity.Produto;
import com.example.minhalojinha.entity.Venda;
import com.example.minhalojinha.exceptions.InfoException;
import com.example.minhalojinha.repository.ItensVendaRepository;
import com.example.minhalojinha.repository.ProdutoRepository;
import com.example.minhalojinha.repository.VendaRepository;
import com.example.minhalojinha.service.itensVenda.ItensVendaServiceImpl;
import com.example.minhalojinha.util.UtilVenda;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendaServiceImpl extends ItensVendaServiceImpl implements VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    private final ProdutoRepository produtoRepository;

    private final ItensVendaRepository itensVendaRepository;

    @Override
    public List<VendaDTO> buscarTodos() {
        List<Venda> listaVendas = vendaRepository.findAll();

        List<VendaDTO> vendaDTOList = new ArrayList<>();
        if (listaVendas.size() > 0) {
            for (Venda venda : listaVendas) {
                List<ItensVenda> itensVendaList = itensVendaRepository.findItensVendasByVendaId(venda.getId());

                if (itensVendaList != null && itensVendaList.size() > 0) {
                    List<ItensVenda> listaItens = new ArrayList<>(itensVendaList);
                    venda.setItensVenda(listaItens);
                }
                vendaDTOList.add(UtilVenda.converteVenda(venda));
            }
        }
        return vendaDTOList;
    }

    @Override
    public VendaDTO inserir(Venda venda) throws InfoException {
        if (UtilVenda.validarVenda(venda)) {
            List<Produto> produtos = new ArrayList<>();

            for (ItensVenda itensVenda : venda.getItensVenda()) {
                itensVenda.setVenda(venda);
                inserirItensVenda(itensVenda);

                Optional<Produto> optionalProduto = produtoRepository.findById(itensVenda.getProduto().getId());
                if (optionalProduto.isPresent()) {
                    produtos.addAll(optionalProduto.stream().collect(Collectors.toList()));

                    for (Produto produto : produtos) {
                        itensVenda.setProduto(produto);
                    }
                }
            }
            vendaRepository.save(venda);
            return UtilVenda.converteVenda(venda);
        } else {
            throw new InfoException("Ocorreu um erro ao cadastrar venda", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void excluir(Long id) throws InfoException {
        Optional<Venda> venda = vendaRepository.findById(id);

        if (venda.isPresent()) {
            excluirItensVenda(id);
            vendaRepository.delete(venda.get());
        } else {
            throw new InfoException("Venda não encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
