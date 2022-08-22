package com.example.minhalojinha.dto;

import com.example.minhalojinha.model.Funcionario;
import com.example.minhalojinha.model.ItensVenda;
import com.example.minhalojinha.model.Pessoa;
import com.example.minhalojinha.model.Venda;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public class VendaDTO {
    private Date dataVenda;
    private Funcionario funcionario;
    private Pessoa pessoa;
    private List<ItensVenda> itensVenda;

    public VendaDTO convert(Venda venda) {
        VendaDTO vendaDTO = new VendaDTO();
        BeanUtils.copyProperties(venda, vendaDTO);
        return vendaDTO;
    }

    public Page<VendaDTO> convertVenda(Page<Venda> pageVenda) {
        return pageVenda.map(this::convert);
    }
}