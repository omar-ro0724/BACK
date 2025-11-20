package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.Paqueteria;
import com.example.APP.Repository.PaqueteriaRepository;
import com.example.APP.Service.PaqueteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaqueteriaServiceImpl implements PaqueteriaService {

    @Autowired
    private PaqueteriaRepository paqueteriaRepository;

    @Override
    public List<Paqueteria> obtenerTodos() {
        return paqueteriaRepository.findAll();
    }

    @Override
    public Optional<Paqueteria> obtenerPorId(Long id) {
        return paqueteriaRepository.findById(id);
    }

    @Override
    public Paqueteria guardar(Paqueteria paqueteria) {
        return paqueteriaRepository.save(paqueteria);
    }

    @Override
    public void eliminar(Long id) {
        paqueteriaRepository.deleteById(id);
    }
}
