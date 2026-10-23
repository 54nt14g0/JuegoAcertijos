package org.santi.Services;

import org.santi.Entity.Acertijo;
import org.santi.Entity.Nivel;

import java.util.List;

public interface NivelService {


    Acertijo obtenerAcertijo(Long idAcertijo);
    List<Acertijo> obtenerAcertijos(Long idNivel);
    String borrarAcertijo (Long idAcertijo);
    Acertijo crearAcertijo (String nombre, String descripcion,String tipoAcertijo, Long idNivel);
    String actualizarAcertijo (Long idAcertijo, String nombre, String descripcion);

    String agregarImagenAcertijo (String url, Long idAcertijo);






}
