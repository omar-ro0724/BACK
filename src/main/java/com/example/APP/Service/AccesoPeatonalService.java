package com.example.APP.Service;

import com.example.APP.Model.AccesoPeatonal;

import java.util.List;
import java.util.Optional;

public interface AccesoPeatonalService {

    List<AccesoPeatonal> obtenerTodos();
    Optional<AccesoPeatonal> obtenerPorId(Long id);
    AccesoPeatonal guardar(AccesoPeatonal accesoPeatonal);
    void eliminar(Long id);
}

