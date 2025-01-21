package com.uni.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatoLogin(
        @NotBlank String usuario,
        @NotBlank String clave
) {
}
