package org.santi.Services;

import org.santi.Entity.Acertijo;

import java.util.List;

public interface NivelService {


    Acertijo obtenerAcertijo();
    List<Acertijo> obtenerAcertijos();
}
