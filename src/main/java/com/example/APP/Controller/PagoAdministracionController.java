package com.example.APP.Controller;

import com.example.APP.Model.PagoAdministracion;
import com.example.APP.Service.PagoAdministracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class PagoAdministracionController {

    @Autowired
    private PagoAdministracionService pagoAdministracionService;

    @GetMapping
    public List<PagoAdministracion> obtenerTodos() {
        return pagoAdministracionService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<PagoAdministracion> obtenerPorId(@PathVariable Long id) {
        return pagoAdministracionService.obtenerPorId(id);
    }

    @PostMapping
    public PagoAdministracion guardar(@RequestBody PagoAdministracion pagoAdministracion) {
        return pagoAdministracionService.guardar(pagoAdministracion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pagoAdministracionService.eliminar(id);
    }
}
