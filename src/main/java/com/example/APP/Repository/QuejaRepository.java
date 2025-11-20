package com.example.APP.Repository;

import com.example.APP.Model.Queja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuejaRepository extends JpaRepository<Queja, Long> {
    List<Queja> findByEstado(Queja.Estado estado);
}
