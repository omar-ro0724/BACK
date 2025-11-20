package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.Queja;
import com.example.APP.Repository.QuejaRepository;
import com.example.APP.Service.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuejaServiceImpl implements QuejaService {

    @Autowired
    private QuejaRepository quejaRepository;

    @Override
    public List<Queja> obtenerTodos() {
        return quejaRepository.findAll();
    }

    @Override
    public Optional<Queja> obtenerPorId(Long id) {
        return quejaRepository.findById(id);
    }

    @Override
    public Queja guardar(Queja queja) {
        return quejaRepository.save(queja);
    }

    @Override
    public void eliminar(Long id) {
        quejaRepository.deleteById(id);
    }
}
