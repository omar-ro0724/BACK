package com.example.APP.Controller;

import com.example.APP.Model.Visitante;
import com.example.APP.Service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/visitantes")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;

    @GetMapping
    public List<Visitante> obtenerTodos() {
        return visitanteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Visitante> obtenerPorId(@PathVariable Long id) {
        return visitanteService.obtenerPorId(id);
    }

    @PostMapping
    public Visitante guardar(@RequestBody Visitante visitante) {
        return visitanteService.guardar(visitante);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        visitanteService.eliminar(id);
    }
}
