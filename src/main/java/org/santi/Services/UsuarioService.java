package org.santi.Services;

import org.santi.Entity.Acertijo;
import org.santi.Entity.IntentoRespuesta;
import org.santi.Entity.Respuesta;

import java.time.LocalDate;
import java.util.List;

public interface UsuarioService {

    // CRUD USUARIO


    String borrarCuenta (Long idUsuario);
    String actualizarDatosUsuario (Long idUsuario, String nombre, String email, LocalDate fechaNacimiento);
    String cambiarPass(Long idUsuario, String newPass);


// Aquí se calculan las estadísticas personales del usuario y se muestran
    String verEstadisticasPersonales (Long idUsuario);
//Aquí se selecciona el nivel y se valida si el progreso es el correcto para que el usuario lo pueda jugar
    List<Acertijo> jugarNivel(Long idUsuario, Long idNivel);

// Debe asegurarse de que el sujeto pase con calificacion requrida por el nivel para sumarlo al progreso
    // debe también permitir repetir el nivel, por lo que debe verificar si YA lo pasó, para no repetir el nombre
    // en el progreso, también si se repite el nivel, se suma o resta la calificacion total del nivel
    // Una vez terminado el nivel, no se pueden borrar los intentos porque de ahí se saca la calificacion

    String terminarNivel(Long idUsuario, Long idNivel, List <IntentoRespuesta> intentos);

    // CRUD de intentos
    IntentoRespuesta intentar (Long idUsuario, Long idRespuesta, String respuestaIntento);
    IntentoRespuesta obtenerIntento (Long idIntento);
    String borrarIntento (Long idIntento);
    String actualizarintento (String respuestaIntento);

}
