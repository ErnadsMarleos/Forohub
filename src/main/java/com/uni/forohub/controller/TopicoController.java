package com.uni.forohub.controller;

import com.uni.forohub.dto.*;
import com.uni.forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity<?> registrarTopico(@Valid @RequestBody TopicoRegistroDTO dto,
                                             UriComponentsBuilder uriComponentsBuilder) {
        try {
            TopicoRespuestaDTO respuesta = service.registrarTopico(dto);
            URI url = uriComponentsBuilder.path("/api/topicos/{id}").buildAndExpand(respuesta.idTopico()).toUri();
            return ResponseEntity.created(url).body(respuesta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Page<TopicoListadoDTO>> listarTopicos(
            @PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion) {
        Page<TopicoListadoDTO> topicos = service.listarTopicos(paginacion);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerDetalleTopico(@PathVariable Long id) {
        try {
            TopicoDetalleDTO detalle = service.obtenerDetalleTopico(id);
            return ResponseEntity.ok(detalle);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarTopico(@PathVariable Long id, @Valid @RequestBody TopicoActualizacionDTO dto) {
        try {
            TopicoDetalleDTO actualizado = service.actualizarTopico(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        try {
            service.eliminarTopico(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

