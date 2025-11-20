package com.example.APP.Controller;

import com.example.APP.Model.Paqueteria;
import com.example.APP.Service.PaqueteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paqueteria")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class PaqueteriaController {

    @Autowired
    private PaqueteriaService paqueteriaService;

    @GetMapping
    public List<Paqueteria> obtenerTodos() {
        return paqueteriaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Paqueteria> obtenerPorId(@PathVariable Long id) {
        return paqueteriaService.obtenerPorId(id);
    }

    @PostMapping
    public Paqueteria guardar(@RequestBody Paqueteria paqueteria) {
        return paqueteriaService.guardar(paqueteria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        paqueteriaService.eliminar(id);
    }
}
