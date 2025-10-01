package br.com.movieflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(@Schema(type = "string", description = "token para login")
                            String token) {
}
