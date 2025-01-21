package com.uni.forohub.dto;

import java.time.LocalDateTime;

public record TopicoDetalleDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String estado,
        String nombreAutor,
        String nombreCurso) {
}
