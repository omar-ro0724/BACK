package com.example.APP.Controller;

import com.example.APP.Model.ReservaZonaComun;
import com.example.APP.Service.ReservaZonaComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class ReservaZonaComunController {

    @Autowired
    private ReservaZonaComunService reservaZonaComunService;

    @GetMapping
    public List<ReservaZonaComun> obtenerTodos() {
        return reservaZonaComunService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<ReservaZonaComun> obtenerPorId(@PathVariable Long id) {
        return reservaZonaComunService.obtenerPorId(id);
    }

    @PostMapping
    public ReservaZonaComun guardar(@RequestBody ReservaZonaComun reservaZonaComun) {
        return reservaZonaComunService.guardar(reservaZonaComun);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaZonaComunService.eliminar(id);
    }
}
