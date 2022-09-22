package com.estacio.evento.controller;

import com.estacio.evento.dto.CategoriaDTO;
import com.estacio.evento.mapper.CategoriaMapper;
import com.estacio.evento.model.Categoria;
import com.estacio.evento.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<CategoriaDTO> categoriasDTO = categoriaMapper.paraCategoriasDTO(categoriaService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(categoriasDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(id);
        if (!categoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoriaOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        if (categoriaService.existsByNome(categoriaDTO.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Categoria já existente");
        }

        Categoria categoria = categoriaMapper.categoriaDTOParaCategoria(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));

    }
}
