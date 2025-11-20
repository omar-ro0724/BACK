package com.example.APP.Service;

import com.example.APP.Model.Mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaService {

    List<Mascota> obtenerTodos();
    Optional<Mascota> obtenerPorId(Long id);
    Mascota guardar(Mascota mascota);
    void eliminar(Long id);
}
