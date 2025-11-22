package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.Paqueteria;
import com.example.APP.Model.Usuario;
import com.example.APP.Repository.PaqueteriaRepository;
import com.example.APP.Repository.UsuarioRepository;
import com.example.APP.Service.PaqueteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaqueteriaServiceImpl implements PaqueteriaService {

    @Autowired
    private PaqueteriaRepository paqueteriaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Paqueteria> obtenerTodos() {
        return paqueteriaRepository.findAll();
    }

    @Override
    public Optional<Paqueteria> obtenerPorId(Long id) {
        return paqueteriaRepository.findById(id);
    }

    @Override
    public Paqueteria guardar(Paqueteria paqueteria) {
        // Si el usuario tiene solo el ID, cargar el usuario completo desde la base de datos
        if (paqueteria.getUsuario() != null && paqueteria.getUsuario().getId() != null) {
            Optional<Usuario> usuarioOpt = usuarioRepository.findById(paqueteria.getUsuario().getId());
            if (usuarioOpt.isPresent()) {
                paqueteria.setUsuario(usuarioOpt.get());
            } else {
                throw new RuntimeException("Usuario no encontrado con id: " + paqueteria.getUsuario().getId());
            }
        }
        
        // Si no hay fecha, asignar la fecha actual
        if (paqueteria.getFechaRecepcion() == null) {
            paqueteria.setFechaRecepcion(java.time.LocalDateTime.now());
        }
        
        // Si no hay estado, asignar PENDIENTE por defecto
        if (paqueteria.getEstado() == null) {
            paqueteria.setEstado(Paqueteria.Estado.PENDIENTE);
        }
        
        return paqueteriaRepository.save(paqueteria);
    }

    @Override
    public Paqueteria actualizar(Long id, Paqueteria paqueteria) {
        return paqueteriaRepository.findById(id)
                .map(existing -> {
                    if (paqueteria.getTransportadora() != null) {
                        existing.setTransportadora(paqueteria.getTransportadora());
                    }
                    if (paqueteria.getFechaRecepcion() != null) {
                        existing.setFechaRecepcion(paqueteria.getFechaRecepcion());
                    }
                    if (paqueteria.getEstado() != null) {
                        existing.setEstado(paqueteria.getEstado());
                    }
                    if (paqueteria.getUsuario() != null) {
                        // Si el usuario tiene solo el ID, cargar el usuario completo desde la base de datos
                        if (paqueteria.getUsuario().getId() != null) {
                            Optional<Usuario> usuarioOpt = usuarioRepository.findById(paqueteria.getUsuario().getId());
                            if (usuarioOpt.isPresent()) {
                                existing.setUsuario(usuarioOpt.get());
                            }
                        } else {
                            existing.setUsuario(paqueteria.getUsuario());
                        }
                    }
                    return paqueteriaRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Paquete no encontrado con id: " + id));
    }

    @Override
    public void eliminar(Long id) {
        paqueteriaRepository.deleteById(id);
    }
}
