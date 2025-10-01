package br.com.movieflix.controller;

import br.com.movieflix.config.TokenService;
import br.com.movieflix.controller.request.LoginRequest;
import br.com.movieflix.controller.request.UserRequest;
import br.com.movieflix.controller.response.LoginResponse;
import br.com.movieflix.controller.response.UserResponse;
import br.com.movieflix.entity.User;
import br.com.movieflix.exception.UsernameOrPasswordInvalidException;
import br.com.movieflix.mapper.UserMapper;
import br.com.movieflix.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("movieflix/auth")
@RestController
public class AuthController {

    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Operation(
            summary = "Registrar usuário",
            description = "Método responsável por cadastrar um novo usuário."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Usuário criado com sucesso.",
            content = @Content(schema = @Schema(implementation = UserResponse.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro de validação nos dados enviados."
    )
    @ApiResponse(
            responseCode = "500",
            description = "Erro interno no servidor."
    )
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register (@RequestBody UserRequest userRequest){
        User savedUser = service.saveUser(UserMapper.toUser(userRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

    @Operation(
            summary = "Login do usuário",
            description = "Método responsável por autenticar um usuário e retornar o token JWT."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Login realizado com sucesso.",
            content = @Content(schema = @Schema(implementation = LoginResponse.class))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro de validação nos dados enviados."
    )
    @ApiResponse(
            responseCode = "401",
            description = "Usuário ou senha inválida."
    )
    @ApiResponse(
            responseCode = "500",
            description = "Erro interno no servidor."
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest request){
        try{
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authenticate = authenticationManager.authenticate(userAndPass);

            User user = (User) authenticate.getPrincipal();

            String token = tokenService.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));
        }catch (BadCredentialsException e){
            throw new UsernameOrPasswordInvalidException("Usuário ou senha inválida");
        }
    }
}
