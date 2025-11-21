package com.example.APP.Controller;

import com.example.APP.Model.Notificacion;
import com.example.APP.Service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public List<Notificacion> obtenerTodos() {
        return notificacionService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Notificacion> obtenerPorId(@PathVariable Long id) {
        return notificacionService.obtenerPorId(id);
    }

    @PostMapping
    public Notificacion guardar(@RequestBody Notificacion notificacion) {
        // Si no tiene fecha, asignar la fecha actual
        if (notificacion.getFechaEnvio() == null) {
            notificacion.setFechaEnvio(java.time.LocalDateTime.now());
        }
        return notificacionService.guardar(notificacion);
    }

    @PutMapping("/{id}")
    public Notificacion actualizar(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        return notificacionService.actualizar(id, notificacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        notificacionService.eliminar(id);
    }
}
