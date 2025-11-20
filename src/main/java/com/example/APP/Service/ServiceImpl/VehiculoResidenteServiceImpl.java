package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.VehiculoResidente;
import com.example.APP.Repository.VehiculoResidenteRepository;
import com.example.APP.Service.VehiculoResidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoResidenteServiceImpl implements VehiculoResidenteService {

    @Autowired
    private VehiculoResidenteRepository vehiculoResidenteRepository;

    @Override
    public List<VehiculoResidente> obtenerTodos() {
        return vehiculoResidenteRepository.findAll();
    }

    @Override
    public Optional<VehiculoResidente> obtenerPorId(Long id) {
        return vehiculoResidenteRepository.findById(id);
    }

    @Override
    public VehiculoResidente guardar(VehiculoResidente vehiculoResidente) {
        return vehiculoResidenteRepository.save(vehiculoResidente);
    }

    @Override
    public void eliminar(Long id) {
        vehiculoResidenteRepository.deleteById(id);
    }
}