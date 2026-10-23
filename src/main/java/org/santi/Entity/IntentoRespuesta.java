package org.santi.Entity;

import jakarta.persistence.*;

@Entity
public class IntentoRespuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Esto es lo que el USUARIO digita o selecciona
    // Si es escrita 'e' contiene la palabra
    // Si es seleccion multiple 'sm' contiene '' vacío si no la responde o 'x' si si
    // Si es 'mr' lo mismo que 'sm'
    @Column
    private String respuestaUsuario;

    //Esto es la RESPUESTA asociada
    @ManyToOne
    @JoinColumn (name = "respuesta_id")
    private Respuesta respuesta;

    @ManyToOne
    @JoinColumn (name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn (name = "acertijo_id")
    private Acertijo acertijo;


    public IntentoRespuesta() {
    }

    public IntentoRespuesta(Usuario usuario, Respuesta respuesta, String respuestaUsuario) {
        this.usuario = usuario;
        this.respuesta = respuesta;
        this.respuestaUsuario = respuestaUsuario;
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
