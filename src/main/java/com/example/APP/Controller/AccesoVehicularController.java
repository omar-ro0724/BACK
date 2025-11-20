package com.example.APP.Controller;

import com.example.APP.Model.AccesoVehicular;
import com.example.APP.Service.AccesoVehicularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accesos-vehiculares")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class AccesoVehicularController {

    @Autowired
    private AccesoVehicularService accesoVehicularService;

    @GetMapping
    public
    List<AccesoVehicular> obtenerTodos() {
        return accesoVehicularService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<AccesoVehicular> obtenerPorId(@PathVariable Long id) {
        return accesoVehicularService.obtenerPorId(id);
    }

    @PostMapping
    public AccesoVehicular guardar(@RequestBody AccesoVehicular accesoVehicular) {
        return accesoVehicularService.guardar(accesoVehicular);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        accesoVehicularService.eliminar(id);
    }
}
