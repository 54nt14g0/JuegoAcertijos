package org.santi.Services;

import org.santi.Entity.Juego;
import org.santi.Entity.Nivel;

import java.util.List;

public interface JuegoService {


    String verEstadisticasGlobales();

    // CRUD niveles
    List<Nivel> obtenerNiveles();
    Nivel obtenerNivelById (Long idNivel);
    String eliminarNivel (Long idNivel);
    Nivel crearNivel (String nombre, String dificultad, String descripcion, String requisitos, Long minimaCalificacionGanar, Long idJuego);
    String actualizarNivel (String nombre, String dificultad, String descripcion, String requisitos, Long minimaCalificacionGanar);

    String agregarFondoNivel (String url);
    String agregarMusicaNivel (String url);



}
