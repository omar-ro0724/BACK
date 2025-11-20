package com.example.APP.Service;

import com.example.APP.Model.AccesoVehicular;

import java.util.List;
import java.util.Optional;

public interface AccesoVehicularService {

    List<AccesoVehicular> obtenerTodos();
    Optional<AccesoVehicular> obtenerPorId(Long id);
    AccesoVehicular guardar(AccesoVehicular accesoVehicular);
    void eliminar(Long id);
}
