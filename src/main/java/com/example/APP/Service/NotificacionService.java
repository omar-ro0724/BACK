package com.example.APP.Service;

import com.example.APP.Model.Notificacion;

import java.util.List;
import java.util.Optional;

public interface NotificacionService {

    List<Notificacion> obtenerTodos();
    Optional<Notificacion> obtenerPorId(Long id);
    Notificacion guardar(Notificacion notificacion);
    Notificacion actualizar(Long id, Notificacion notificacion);
    void eliminar(Long id);
}
