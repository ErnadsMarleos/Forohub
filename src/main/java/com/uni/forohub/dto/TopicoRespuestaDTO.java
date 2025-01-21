package com.uni.forohub.dto;

import java.time.LocalDateTime;

public record TopicoRespuestaDTO(
        Long idTopico,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion
) {
}
