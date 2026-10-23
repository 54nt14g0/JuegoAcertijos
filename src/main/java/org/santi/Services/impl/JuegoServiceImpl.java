package org.santi.Services.impl;

import org.santi.Entity.Juego;
import org.santi.Entity.Nivel;
import org.santi.Exception.JuegoNotFoundException;
import org.santi.Repository.JuegoRepository;
import org.santi.Services.JuegoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoServiceImpl implements JuegoService {

    private final JuegoRepository juegoRepository;

    public JuegoServiceImpl(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @Override
    public Juego obtenerJuego(Long id) {

        Juego juego = juegoRepository.findById(id).orElseThrow(()->
                new JuegoNotFoundException("No se encontró el Juego"));

        return juego;
    }

    @Override
    public String verEstadisticasGlobales() {
        return "";
    }

    @Override
    public List<Nivel> obtenerNiveles(Long idJuego) {


        Juego juego = juegoRepository.findById(idJuego).orElseThrow(()->
                new JuegoNotFoundException("No se encontró el Juego"));

        return juego.getNiveles();
    }

    @Override
    public Nivel obtenerNivelById(Long idNivel) {
        return null;
    }

    @Override
    public String eliminarNivel(Long idNivel) {
        return "";
    }

    @Override
    public Nivel crearNivel(String nombre, String dificultad, String descripcion, String requisitos, Long minimaCalificacionGanar, Long idJuego) {
        return null;
    }

    @Override
    public String actualizarNivel(String nombre, String dificultad, String descripcion, String requisitos, Long minimaCalificacionGanar) {
        return "";
    }

    @Override
    public String agregarFondoNivel(String url) {
        return "";
    }

    @Override
    public String agregarMusicaNivel(String url) {
        return "";
    }
}
