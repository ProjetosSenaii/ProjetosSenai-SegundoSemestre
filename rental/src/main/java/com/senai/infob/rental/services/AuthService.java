package com.senai.infob.rental.services;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.senai.infob.rental.enums.Role;
import com.senai.infob.rental.models.AuthRequest;
import com.senai.infob.rental.models.AuthResponse;
import com.senai.infob.rental.models.Usuario;
import com.senai.infob.rental.repositories.UsuarioRepository;

@Service 
public class AuthService {

    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(
            UsuarioRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(AuthRequest request) {
        Usuario usuario = new Usuario(
                request.username(),
                request.email(),
                passwordEncoder.encode(request.password()), // Criptografa a senha com BCrypt
                Role.USER
        );

        userRepository.save(usuario);

        String jwtToken = jwtService.gerarToken(usuario.getUsername());
        return new AuthResponse(jwtToken);
    }

    public AuthResponse authenticate(AuthRequest request) {
        // Valida as credenciais enviadas no Login
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        // Se a autenticação passar sem disparar exceção, busca o usuário e gera o token
        Usuario usuario = userRepository.findByEmail(request.email())
                .orElseThrow();

        String jwtToken = jwtService.gerarToken(usuario.getEmail());
        return new AuthResponse(jwtToken);
    }
}