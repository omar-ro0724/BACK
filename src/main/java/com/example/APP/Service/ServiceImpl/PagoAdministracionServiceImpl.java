package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.PagoAdministracion;
import com.example.APP.Repository.PagoAdministracionRepository;
import com.example.APP.Service.PagoAdministracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoAdministracionServiceImpl implements PagoAdministracionService {

    @Autowired
    private PagoAdministracionRepository pagoAdministracionRepository;

    @Override
    public List<PagoAdministracion> obtenerTodos() {
        return pagoAdministracionRepository.findAll();
    }

    @Override
    public Optional<PagoAdministracion> obtenerPorId(Long id) {
        return pagoAdministracionRepository.findById(id);
    }

    @Override
    public PagoAdministracion guardar(PagoAdministracion pagoAdministracion) {
        return pagoAdministracionRepository.save(pagoAdministracion);
    }

    @Override
    public void eliminar(Long id) {
        pagoAdministracionRepository.deleteById(id);
    }
}
