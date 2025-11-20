package com.example.APP.Controller;

import com.example.APP.Model.VehiculoResidente;
import com.example.APP.Service.VehiculoResidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculos-residentes")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class VehiculoResidenteController {

    @Autowired
    private VehiculoResidenteService vehiculoResidenteService;

    @GetMapping
    public List<VehiculoResidente> obtenerTodos() {
        return vehiculoResidenteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<VehiculoResidente> obtenerPorId(@PathVariable Long id) {
        return vehiculoResidenteService.obtenerPorId(id);
    }

    @PostMapping
    public VehiculoResidente guardar(@RequestBody VehiculoResidente vehiculoResidente) {
        return vehiculoResidenteService.guardar(vehiculoResidente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        vehiculoResidenteService.eliminar(id);
    }
}