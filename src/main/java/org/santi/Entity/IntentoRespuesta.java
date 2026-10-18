package org.santi.Entity;

import jakarta.persistence.*;

@Entity
public class IntentoRespuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isTake;
    private String respuestaUsuario;

    @ManyToOne
    @JoinColumn (name = "respuesta_id")
    private Respuesta respuesta;

    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario usuario;


    public IntentoRespuesta() {
    }

    public IntentoRespuesta(Usuario usuario, Respuesta respuesta, String respuestaUsuario) {
        this.usuario = usuario;
        this.respuesta = respuesta;
        this.respuestaUsuario = respuestaUsuario;
    }

    public IntentoRespuesta(boolean isTake, Respuesta respuesta, Usuario usuario) {
        this.isTake = isTake;
        this.respuesta = respuesta;
        this.usuario = usuario;
    }

    public boolean isTake() {
        return isTake;
    }

    public void setTake(boolean take) {
        isTake = take;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespuestaUsuario() {
        return respuestaUsuario;
    }

    public void setRespuestaUsuario(String respuestaUsuario) {
        this.respuestaUsuario = respuestaUsuario;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
