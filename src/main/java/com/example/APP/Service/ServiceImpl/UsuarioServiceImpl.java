package com.example.APP.Service.ServiceImpl;

import com.example.APP.Model.Usuario;
import com.example.APP.Repository.UsuarioRepository;
import com.example.APP.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario login(String usuario, String password) {
        return usuarioRepository
                .findByUsuario(usuario)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Usuario o contraseña incorrectos"));
    }

}