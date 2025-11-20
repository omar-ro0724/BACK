package com.example.APP.Service;

import com.example.APP.Model.Visitante;

import java.util.List;
import java.util.Optional;

public interface VisitanteService {

    List<Visitante> obtenerTodos();
    Optional<Visitante> obtenerPorId(Long id);
    Visitante guardar(Visitante visitante);
    void eliminar(Long id);
}
