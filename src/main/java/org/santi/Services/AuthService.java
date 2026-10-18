package org.santi.Services;

import org.santi.Entity.Usuario;
import org.santi.Exception.CorreoYaRegistradoException;
import org.santi.Repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class AuthService {


    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;


    public AuthService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }


    public Usuario registrarUsuario(
            String nombre,
            String pass,
            String email,
            LocalDate fechaNacimiento) {

        if (usuarioRepository.existsByEmail(email)) {
            throw new CorreoYaRegistradoException(
                    "El correo ya está registrado"
            );
        }

        Usuario usuario = new Usuario(
                nombre,
                pass,
                email,
                fechaNacimiento
        );

        usuario.setPass(passwordEncoder.encode(pass));

        return usuarioRepository.save(usuario);
    }

    public Usuario login(String email, String pass) {

        String mensaje = "Credenciales incorrectas";

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException(mensaje)
                );

        boolean coinciden = passwordEncoder.matches(
                pass,
                usuario.getPass()
        );

        if (!coinciden) {
            throw new IllegalArgumentException(mensaje);
        }

        return usuario;
    }


}
