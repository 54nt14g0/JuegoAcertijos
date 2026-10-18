package org.santi.Services;

import org.santi.Entity.Acertijo;
import org.santi.Entity.Nivel;

import java.util.List;

public interface NivelService {


    Acertijo obtenerAcertijo(Long idAcertijo);
    List<Acertijo> obtenerAcertijos();
    String borrarAcertijo (Long idAcertijo);
    Acertijo crearAcertijo (String nombre, String descripcion, Long idNivel);
    String actualizarAcertijo (Long idAcertijo, String nombre, String descripcion);

    String agregarImagenAcertijo (String url, Long idAcertijo);






}
