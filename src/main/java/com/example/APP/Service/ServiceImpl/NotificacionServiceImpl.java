package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.Notificacion;
import com.example.APP.Model.Usuario;
import com.example.APP.Repository.NotificacionRepository;
import com.example.APP.Repository.UsuarioRepository;
import com.example.APP.Service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Notificacion> obtenerTodos() {
        return notificacionRepository.findAll();
    }

    @Override
    public Optional<Notificacion> obtenerPorId(Long id) {
        return notificacionRepository.findById(id);
    }

    @Override
    public Notificacion guardar(Notificacion notificacion) {
        // Siempre cargar el usuario completo desde la base de datos usando el ID
        // Esto asegura que el usuario tenga todos los campos correctos, incluyendo el rol
        if (notificacion.getUsuario() != null && notificacion.getUsuario().getId() != null) {
            Long usuarioId = notificacion.getUsuario().getId();
            Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
            if (usuarioOpt.isPresent()) {
                // Usar el usuario completo desde la base de datos
                Usuario usuarioCompleto = usuarioOpt.get();
                notificacion.setUsuario(usuarioCompleto);
                System.out.println("NotificacionServiceImpl: Usuario cargado desde BD - ID: " + usuarioCompleto.getId() + 
                                   ", Nombre: " + usuarioCompleto.getNombre() + 
                                   ", Rol: " + usuarioCompleto.getRol());
            } else {
                throw new RuntimeException("Usuario no encontrado con id: " + usuarioId);
            }
        } else if (notificacion.getUsuario() == null) {
            throw new RuntimeException("La notificación debe tener un usuario asignado");
        }
        
        // Si no hay fecha, asignar la fecha actual
        if (notificacion.getFechaEnvio() == null) {
            notificacion.setFechaEnvio(java.time.LocalDateTime.now());
        }
        
        System.out.println("NotificacionServiceImpl: Guardando notificación - Mensaje: " + notificacion.getMensaje() + 
                           ", Usuario ID: " + (notificacion.getUsuario() != null ? notificacion.getUsuario().getId() : "null"));
        
        return notificacionRepository.save(notificacion);
    }

    @Override
    public Notificacion actualizar(Long id, Notificacion notificacion) {
        return notificacionRepository.findById(id)
                .map(existing -> {
                    existing.setMensaje(notificacion.getMensaje());
                    existing.setFechaEnvio(notificacion.getFechaEnvio() != null ? notificacion.getFechaEnvio() : existing.getFechaEnvio());
                    existing.setImagenUrl(notificacion.getImagenUrl());
                    existing.setVideoUrl(notificacion.getVideoUrl());
                    existing.setUsuariosEtiquetados(notificacion.getUsuariosEtiquetados());
                    existing.setUsuario(notificacion.getUsuario());
                    return notificacionRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada con id: " + id));
    }

    @Override
    public void eliminar(Long id) {
        notificacionRepository.deleteById(id);
    }
}
