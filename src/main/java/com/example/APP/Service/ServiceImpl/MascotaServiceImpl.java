package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.Mascota;
import com.example.APP.Repository.MascotaRepository;
import com.example.APP.Service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> obtenerTodos() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> obtenerPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    @Override
    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public void eliminar(Long id) {
        mascotaRepository.deleteById(id);
    }
}