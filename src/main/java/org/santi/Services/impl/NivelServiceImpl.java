package org.santi.Services.impl;

import org.santi.Entity.Acertijo;
import org.santi.Entity.Nivel;
import org.santi.Repository.NivelRepository;
import org.santi.Services.NivelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NivelServiceImpl implements NivelService {

    private final NivelRepository nivelRepository;

    public NivelServiceImpl(NivelRepository nivelRepository) {
        this.nivelRepository = nivelRepository;
    }


    @Override
    public Acertijo obtenerAcertijo(Long idAcertijo) {
        return null;
    }

    @Override
    public List<Acertijo> obtenerAcertijos(Long idNivel) {



        Nivel nivel = nivelRepository.findById(idNivel).orElseThrow(()->
                new IllegalArgumentException("No se encontró el nivel"));

        ArrayList<Acertijo> listaAcertijos = new ArrayList<>(nivel.getAcertijos());

        return listaAcertijos;
    }

    @Override
    public String borrarAcertijo(Long idAcertijo) {
        return "";
    }

    @Override
    public Acertijo crearAcertijo(String nombre, String descripcion, Long idNivel) {
        return null;
    }

    @Override
    public String actualizarAcertijo(Long idAcertijo, String nombre, String descripcion) {
        return "";
    }

    @Override
    public String agregarImagenAcertijo(String url, Long idAcertijo) {
        return "";
    }
}
