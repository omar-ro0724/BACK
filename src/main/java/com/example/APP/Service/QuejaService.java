package com.example.APP.Service;

import com.example.APP.Model.Queja;

import java.util.List;
import java.util.Optional;

public interface QuejaService {

    List<Queja> obtenerTodos();
    Optional<Queja> obtenerPorId(Long id);
    Queja guardar(Queja queja);
    void eliminar(Long id);
}
