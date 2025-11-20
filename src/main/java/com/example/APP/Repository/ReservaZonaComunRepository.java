package com.example.APP.Repository;

import com.example.APP.Model.ReservaZonaComun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaZonaComunRepository extends JpaRepository<ReservaZonaComun, Long> {
    List<ReservaZonaComun> findByUsuarioId(Long usuarioId);
}
