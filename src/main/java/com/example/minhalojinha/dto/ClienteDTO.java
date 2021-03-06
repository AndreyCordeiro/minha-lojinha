package com.example.minhalojinha.dto;

import com.example.minhalojinha.model.entity.Cliente;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

@Data
public class ClienteDTO {
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String email;

    public ClienteDTO convert(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        BeanUtils.copyProperties(cliente, clienteDTO);
        return clienteDTO;
    }

    public Page<ClienteDTO> convertCliente(Page<Cliente> pageCliente) {
        return pageCliente.map(this::convert);
    }
}