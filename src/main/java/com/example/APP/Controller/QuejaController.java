package com.example.APP.Controller;


import com.example.APP.Model.Queja;
import com.example.APP.Service.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quejas")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class QuejaController {

    @Autowired
    private QuejaService quejaService;

    @GetMapping
    public List<Queja> obtenerTodos() {
        return quejaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Queja> obtenerPorId(@PathVariable Long id) {
        return quejaService.obtenerPorId(id);
    }

    @PostMapping
    public Queja guardar(@RequestBody Queja queja) {
        return quejaService.guardar(queja);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        quejaService.eliminar(id);
    }
}


