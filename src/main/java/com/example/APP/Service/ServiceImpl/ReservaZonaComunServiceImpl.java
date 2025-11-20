package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.ReservaZonaComun;
import com.example.APP.Repository.ReservaZonaComunRepository;
import com.example.APP.Service.ReservaZonaComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaZonaComunServiceImpl implements ReservaZonaComunService {

    @Autowired
    private ReservaZonaComunRepository reservaZonaComunRepository;

    @Override
    public List<ReservaZonaComun> obtenerTodos() {
        return reservaZonaComunRepository.findAll();
    }

    @Override
    public Optional<ReservaZonaComun> obtenerPorId(Long id) {
        return reservaZonaComunRepository.findById(id);
    }

    @Override
    public ReservaZonaComun guardar(ReservaZonaComun reservaZonaComun) {
        return reservaZonaComunRepository.save(reservaZonaComun);
    }

    @Override
    public void eliminar(Long id) {
        reservaZonaComunRepository.deleteById(id);
    }
}
