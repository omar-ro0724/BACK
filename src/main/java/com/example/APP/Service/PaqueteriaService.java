package com.example.APP.Service;

import com.example.APP.Model.Paqueteria;

import java.util.List;
import java.util.Optional;

public interface PaqueteriaService {

    List<Paqueteria> obtenerTodos();
    Optional<Paqueteria> obtenerPorId(Long id);
    Paqueteria guardar(Paqueteria paqueteria);
    void eliminar(Long id);
}
