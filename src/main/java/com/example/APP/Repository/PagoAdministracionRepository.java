package com.example.APP.Repository;

import com.example.APP.Model.PagoAdministracion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoAdministracionRepository extends JpaRepository<PagoAdministracion, Long> {
    List<PagoAdministracion> findByUsuarioId(Long usuarioId);
}
