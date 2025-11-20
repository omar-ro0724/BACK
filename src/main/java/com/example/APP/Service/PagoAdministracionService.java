package com.example.APP.Service;

import com.example.APP.Model.PagoAdministracion;

import java.util.List;
import java.util.Optional;

public interface PagoAdministracionService {

    List<PagoAdministracion> obtenerTodos();
    Optional<PagoAdministracion> obtenerPorId(Long id);
    PagoAdministracion guardar(PagoAdministracion pagoAdministracion);
    void eliminar(Long id);
}
