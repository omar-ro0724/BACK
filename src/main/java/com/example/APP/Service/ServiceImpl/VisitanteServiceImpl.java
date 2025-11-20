package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.Visitante;
import com.example.APP.Repository.VisitanteRepository;
import com.example.APP.Service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitanteServiceImpl implements VisitanteService {

    @Autowired
    private VisitanteRepository visitanteRepository;

    @Override
    public List<Visitante> obtenerTodos() {
        return visitanteRepository.findAll();
    }

    @Override
    public Optional<Visitante> obtenerPorId(Long id) {
        return visitanteRepository.findById(id);
    }

    @Override
    public Visitante guardar(Visitante visitante) {
        return visitanteRepository.save(visitante);
    }

    @Override
    public void eliminar(Long id) {
        visitanteRepository.deleteById(id);
    }
}
