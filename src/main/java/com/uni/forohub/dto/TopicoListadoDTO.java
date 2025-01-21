package com.uni.forohub.dto;

import java.time.LocalDateTime;

public record TopicoListadoDTO(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso,
        LocalDateTime fechaCreacion,
        String estado
) {
}
