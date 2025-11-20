package com.example.APP.Controller;

import com.example.APP.Model.AccesoPeatonal;
import com.example.APP.Service.AccesoPeatonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accesos-peatonales")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class AccesoPeatonalController {

    @Autowired
    private AccesoPeatonalService accesoPeatonalService;

    @GetMapping
    public List<AccesoPeatonal> obtenerTodos() {
        return accesoPeatonalService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<AccesoPeatonal> obtenerPorId(@PathVariable Long id) {
        return accesoPeatonalService.obtenerPorId(id);
    }

    @PostMapping
    public AccesoPeatonal guardar(@RequestBody AccesoPeatonal accesoPeatonal) {
        return accesoPeatonalService.guardar(accesoPeatonal);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        accesoPeatonalService.eliminar(id);
    }
}
