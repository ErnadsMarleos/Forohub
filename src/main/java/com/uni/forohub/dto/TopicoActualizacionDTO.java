package com.uni.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicoActualizacionDTO(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        String estado
) {
}
