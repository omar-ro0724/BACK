package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.Notificacion;
import com.example.APP.Repository.NotificacionRepository;
import com.example.APP.Service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

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
        return notificacionRepository.save(notificacion);
    }

    @Override
    public Notificacion actualizar(Long id, Notificacion notificacion) {
        return notificacionRepository.findById(id)
                .map(existing -> {
                    existing.setMensaje(notificacion.getMensaje());
                    existing.setFechaEnvio(notificacion.getFechaEnvio() != null ? notificacion.getFechaEnvio() : existing.getFechaEnvio());
                    existing.setImagenUrl(notificacion.getImagenUrl());
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
