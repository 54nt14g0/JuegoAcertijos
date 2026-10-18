package org.santi.Services;

import org.santi.Entity.IntentoRespuesta;
import org.santi.Entity.Respuesta;

import java.time.LocalDate;
import java.util.List;

public interface UsuarioService {

    // CRUD USUARIO

    String login(String email, String pass);
    String register (String nombre, String pass, String email, LocalDate fechaNacimiento);



// Aquí se calculan las estadísticas personales del usuario y se muestran
    String verEstadisticasPersonales (Long idUsuario);
//Aquí se selecciona el nivel y se valida si el progreso es el correcto para que el usuario lo pueda jugar
    String jugarNivel(Long idUsuario, Long idNivel);


    String terminarNivel(Long idUsuario, Long idNivel, List <IntentoRespuesta> intentos);



}
