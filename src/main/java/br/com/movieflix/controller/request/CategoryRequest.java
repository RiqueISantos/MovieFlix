package br.com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record CategoryRequest(@NotEmpty(message = "Nome da categoria é obrigatório.")
                              @Schema(type = "string", description = "Nome da categoria")
                              String name) {
}
