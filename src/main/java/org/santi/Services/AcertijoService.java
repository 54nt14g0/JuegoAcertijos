package org.santi.Services;

import org.santi.Entity.Acertijo;
import org.santi.Entity.Respuesta;

import java.util.List;

public interface AcertijoService {

    //CRUD respuestas
    List<Respuesta> obtenerRespuestas();
    String borrarRespuesta (Long idRespuesta);
    Respuesta obtenerRespuesta (Long idRespuesta);
    String modificarRespuesta (Long idrespuesta, String nombre, String descripcion, String respuestaCorrecta);

    Respuesta crearRespuesta (String nombre, String descripcion, String respuestaCorrecta, Long idAcertijo);


}
