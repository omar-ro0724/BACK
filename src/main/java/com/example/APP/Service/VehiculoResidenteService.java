package com.example.APP.Service;

import com.example.APP.Model.VehiculoResidente;

import java.util.List;
import java.util.Optional;

public interface VehiculoResidenteService {

    List<VehiculoResidente> obtenerTodos();
    Optional<VehiculoResidente> obtenerPorId(Long id);
    VehiculoResidente guardar(VehiculoResidente vehiculoResidente);
    void eliminar(Long id);
}
