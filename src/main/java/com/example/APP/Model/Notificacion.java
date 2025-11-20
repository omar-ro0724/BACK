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

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
