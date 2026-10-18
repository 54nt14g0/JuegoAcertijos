package org.santi.Services;

import org.santi.Entity.Nivel;

import java.util.List;

public interface JuegoService {


    String verEstadisticasGlobales();


    List<Nivel> obtenerNiveles();
    Nivel obtenerNivelById (Long id);






}
