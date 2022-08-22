package com.example.minhalojinha.controller;

import com.example.minhalojinha.dto.VendaDTO;
import com.example.minhalojinha.exceptions.BadResourceException;
import com.example.minhalojinha.exceptions.ResourceAlreadyExistsException;
import com.example.minhalojinha.exceptions.ResourceNotFoundException;
import com.example.minhalojinha.model.Venda;
import com.example.minhalojinha.service.venda.VendaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VendaController {
    public static final Logger logger = LoggerFactory.getLogger(VendaController.class);

    private VendaService vendaService;

    @GetMapping(value = "/venda", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<VendaDTO>> findAll(@RequestBody(required = false) String nome, Pageable pageable) {
        if (StringUtils.isEmpty(nome)) {
            return ResponseEntity.ok(new VendaDTO().convertVenda(vendaService.findAll(pageable)));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/venda/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> findVendaById(@PathVariable Long id) {
        Venda venda = vendaService.findById(id);
        return ResponseEntity.ok(venda);
    }

    @PostMapping(value = "/venda")
    public ResponseEntity<Venda> realizarVenda(@RequestBody Venda venda)
            throws URISyntaxException {
        try {
            Venda vendaRealizada = vendaService.salvarVenda(venda);
            return ResponseEntity.created(new URI("/api/venda" + vendaRealizada.getId())).body(venda);
        } catch (ResourceAlreadyExistsException | BadResourceException e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(path = "/venda/{id}")
    public ResponseEntity<Void> deleteVendaById(@PathVariable Long id) {
        try {
            vendaService.deleteById(id);
            logger.info("A venda " + id + " foi deletada");
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException ex) {
            logger.error(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "A venda " + id + " não foi encontrada");
        }
    }
}
