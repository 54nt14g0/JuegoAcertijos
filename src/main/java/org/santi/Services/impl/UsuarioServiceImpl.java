package org.santi.Services.impl;

import org.santi.Entity.IntentoRespuesta;
import org.santi.Entity.Usuario;
import org.santi.Services.AuthService;
import org.santi.Services.UsuarioService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {





    @Override
    public String borrarCuenta(Long idUsuario) {
        return "";
    }

    @Override
    public String actualizarDatosUsuario(Long idUsuario, String nombre, String email, LocalDate fechaNacimiento) {
        return "";
    }

    @Override
    public String verEstadisticasPersonales(Long idUsuario) {
        return "";
    }

    @Override
    public String jugarNivel(Long idUsuario, Long idNivel) {
        return "";
    }

    @Override
    public String terminarNivel(Long idUsuario, Long idNivel, List<IntentoRespuesta> intentos) {
        return "";
    }

    @Override
    public IntentoRespuesta intentar(Long idUsuario, Long idRespuesta, String respuestaIntento) {
        return null;
    }

    @Override
    public IntentoRespuesta obtenerIntento(Long idIntento) {
        return null;
    }

    @Override
    public String borrarIntento(Long idIntento) {
        return "";
    }

    @Override
    public String actualizarintento(String respuestaIntento) {
        return "";
    }
}
