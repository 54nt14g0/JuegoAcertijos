package org.santi.Services.impl;

import org.santi.Entity.*;
import org.santi.Exception.CorreoYaRegistradoException;
import org.santi.Exception.UserNotFoundException;
import org.santi.Repository.NivelRepository;
import org.santi.Repository.UsuarioRepository;
import org.santi.Services.AuthService;
import org.santi.Services.UsuarioService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final NivelRepository nivelRepository;
    private final NivelServiceImpl nivelService;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, NivelRepository nivelRepository, NivelServiceImpl nivelService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.nivelRepository = nivelRepository;
        this.nivelService = nivelService;
    }


    @Override
    public String borrarCuenta(Long idUsuario) {

        String mensaje = "No se pudo borrar, id incorrecta";

        if (usuarioRepository.existsById(idUsuario) != true) {
            usuarioRepository.deleteById(idUsuario);
            mensaje = "se ha eliminado su cuetna con éxito";
        }
        return mensaje;
    }

    @Override
    public String actualizarDatosUsuario(
            Long idUsuario,
            String nombre,
            String email,
            LocalDate fechaNacimiento) {

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No se pudo encontrar el usuario"
                        )
                );

        usuario.setNombre(nombre);

        if (usuarioRepository.existsByEmail(email) == false) {
            usuario.setEmail(email);
        } else {
            throw new CorreoYaRegistradoException("este nuevo correo que quiere actualizar YA existe en el sistema");
        }

        usuario.setFechaNacimiento(fechaNacimiento);

        usuarioRepository.save(usuario);

        return "Se ha actualizado con éxito";
    }

    @Override
    public String cambiarPass(Long idUsuario, String newPass) {

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No se pudo encontrar el usuario"
                        )
                );

        usuario.setPass(passwordEncoder.encode(newPass));

        usuarioRepository.save(usuario);

        return "Se ha modificado la contraseña con éxito";
    }


    @Override
    public String verEstadisticasPersonales(Long idUsuario) {
        return "";
    }

    // Método que devuelve TODOS los acertijos del nivel para jugarlo
    //En caso de que acertijos salga VACIO, se interpreta como que NO pasó la verificacion y no puede jugar
    @Override
    public List<Acertijo> jugarNivel(Long idUsuario, Long idNivel) {

        ArrayList<Acertijo> acertijos = new ArrayList<>();

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No se pudo encontrar el usuario"
                        )
                );

        Nivel nivel = nivelRepository.findById(idNivel).orElseThrow(() ->
                new IllegalArgumentException("No se pudo encontrr el Nivel"));

        boolean puedeJuagarNivel = verificarProgreso(usuario, idNivel);

        if (puedeJuagarNivel != false) {

            acertijos = (ArrayList<Acertijo>) nivelService.obtenerAcertijos(idNivel);

        }

        return acertijos;
    }

    // Método que verifica que el nivel a jugar se pueda jugar por parte del usuario
    // Verifica que el usuario ya haya ganado TODOS los niveles previos que son REQUISITO para jugar el NIVEL
    // Si el nivel no tiene requisitos, lo deja pasar normal para jugar
    private boolean verificarProgreso(Usuario usuario, Long idNivel) {

        String userLevels = usuario.getProgreso();

        Nivel nivel = nivelRepository.findById(idNivel).orElseThrow(() ->
                new IllegalArgumentException("no se encontró el nivel"));

        String nameLevel = nivel.getNombre();
        String reqLevel = nivel.getRequisitos();

        String[] levelsWin = userLevels.split(";");
        String[] levelsReq = reqLevel.split(";");

        int contador = 0;
        boolean isWin = false;


        if (reqLevel.equals("")) {

            isWin = true;
        } else {

            for (int i = 0; i < levelsReq.length; i++) {

                for (int j = 0; j < levelsWin.length; j++) {

                    if (levelsReq[i].equalsIgnoreCase(levelsWin[j])) {

                        contador += 1;
                    }
                }
            }

            if (contador == levelsReq.length) {
                isWin = true;
            }
        }


        return isWin;

    }


    // Este metodo verifica la puntuación obtenida y si pasa la puntuacion requerida se considera GANADO
    // Al ganar se añade al STRING progreso de Usuario el nombre del nivel, lo que representa que el usuario AVANZO un nivel más
    @Override
    public String terminarNivel(Long idUsuario, Long idNivel, List<IntentoRespuesta> intentos) {


        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() ->
                new UserNotFoundException("No se encontró el usuario"));

        Nivel nivel = nivelRepository.findById(idNivel).orElseThrow(() ->
                new IllegalArgumentException("No se encontró el nivel"));


        String mensaje = "Lo lamentamos, no ha pasado el nivel, no alcanzó la puntuación necesaria";
        Float calificacionNivel = (float) 0;

        calificacionNivel = calificarIntentoUsuario(usuario, nivel, intentos);

        if (calificacionNivel >= nivel.getMinimaCalificacionGanar()) {

            mensaje = "Felicidades, ha coronado el NIVEL !!";

            if (usuario.getProgreso().equals("") || usuario.getProgreso() == null) {

                usuario.setProgreso(nivel.getNombre());
                usuarioRepository.save(usuario);
            } else {
                String temp = usuario.getProgreso();
                usuario.setProgreso(temp + ";" + nivel.getNombre());
                usuarioRepository.save(usuario);
            }

        }


        return mensaje;
    }

    private Float calificarIntentoUsuario(Usuario usuario, Nivel nivel, List<IntentoRespuesta> intentos) {

        // tener a mano todos los acertijos
        // de cada acertijo tener a mano CADA respuesta y su correspondiente intento
        // la operación es tomar las buenas por acertijo y multiplicarlas por el peso, luego sumar todo

        ArrayList<Acertijo> acertijos = new ArrayList<>(nivelService.obtenerAcertijos(nivel.getId()));

        Float calificacion = (float) 0;


        for (int i = 0; i < intentos.size(); i++) {

            for (int j = 0; j < acertijos.size(); j++) {

                Float temp = (float) 0;

                ArrayList<Respuesta> respuestasAcertijo = new ArrayList<>(acertijos.get(j).getRespuestas());

                for (int k = 0; k < respuestasAcertijo.size(); k++) {

                    Long idRespuestaAsociada = intentos.get(i).getRespuesta().getId();
                    Long idRespuesta = respuestasAcertijo.get(k).getId();

                    if (idRespuestaAsociada.equals(idRespuesta)) {

                        String tipoAcertijo = acertijos.get(j).getTipoAcertijo();

                        Respuesta respuesta = respuestasAcertijo.get(k);
                        IntentoRespuesta intento = intentos.get(i);


                        //'e' = escrito , 'sm' = seleccion multiple , 'mr' = multiples respuestas
                        if (tipoAcertijo.equalsIgnoreCase("e")) {

                            if (respuesta.getRespuestaCorrecta().equalsIgnoreCase(intento.getRespuestaUsuario())) {

                                temp += 1;
                            }
                        }

                        if (tipoAcertijo.equalsIgnoreCase("sm") || tipoAcertijo.equalsIgnoreCase("mr")) {

                            if (respuesta.getRespuestaCorrecta().equalsIgnoreCase("true")
                                    && intento.getRespuestaUsuario().equalsIgnoreCase("x")) {

                                temp += 1;
                            }

                        }

                    }


                }

                calificacion += (temp / acertijos.get(j).getCantidadCorrectas()) * acertijos.get(j).getPeso();
            }
        }
        return calificacion;

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
