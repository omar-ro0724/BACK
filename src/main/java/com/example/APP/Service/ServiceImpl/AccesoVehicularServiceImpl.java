package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.AccesoVehicular;
import com.example.APP.Repository.AccesoVehicularRepository;
import com.example.APP.Service.AccesoVehicularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccesoVehicularServiceImpl implements AccesoVehicularService {

    @Autowired
    private AccesoVehicularRepository accesoVehicularRepository;

    @Override
    public List<AccesoVehicular> obtenerTodos() {
        return accesoVehicularRepository.findAll();
    }

    @Override
    public Optional<AccesoVehicular> obtenerPorId(Long id) {
        return accesoVehicularRepository.findById(id);
    }

    @Override
    public AccesoVehicular guardar(AccesoVehicular accesoVehicular) {
        return accesoVehicularRepository.save(accesoVehicular);
    }

    @Override
    public void eliminar(Long id) {
        accesoVehicularRepository.deleteById(id);
    }
}