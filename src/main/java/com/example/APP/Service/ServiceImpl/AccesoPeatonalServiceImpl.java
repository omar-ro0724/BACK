package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.AccesoPeatonal;
import com.example.APP.Repository.AccesoPeatonalRepository;
import com.example.APP.Service.AccesoPeatonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccesoPeatonalServiceImpl implements AccesoPeatonalService {

    @Autowired
    private AccesoPeatonalRepository accesoPeatonalRepository;

    @Override
    public List<AccesoPeatonal> obtenerTodos() {
        return accesoPeatonalRepository.findAll();
    }

    @Override
    public Optional<AccesoPeatonal> obtenerPorId(Long id) {
        return accesoPeatonalRepository.findById(id);
    }

    @Override
    public AccesoPeatonal guardar(AccesoPeatonal accesoPeatonal) {
        return accesoPeatonalRepository.save(accesoPeatonal);
    }

    @Override
    public void eliminar(Long id) {
        accesoPeatonalRepository.deleteById(id);
    }
}