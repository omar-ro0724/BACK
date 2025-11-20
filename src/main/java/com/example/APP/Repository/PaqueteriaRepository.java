package com.example.APP.Repository;

import com.example.APP.Model.Paqueteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaqueteriaRepository extends JpaRepository<Paqueteria, Long> {
    List<Paqueteria> findByUsuarioId(Long usuarioId);
}
