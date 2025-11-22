package com.example.APP.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private LocalDateTime fechaEnvio;
    private String imagenUrl;  // Ruta de la imagen adjunta
    private String videoUrl;  // Ruta del video adjunto
    private String usuariosEtiquetados;  // JSON array de IDs de usuarios etiquetados

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Constructores
    public Notificacion() {
    }

    // Getters y Setters manuales (por si Lombok no funciona correctamente)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getUsuariosEtiquetados() {
        return usuariosEtiquetados;
    }

    public void setUsuariosEtiquetados(String usuariosEtiquetados) {
        this.usuariosEtiquetados = usuariosEtiquetados;
    }
}
