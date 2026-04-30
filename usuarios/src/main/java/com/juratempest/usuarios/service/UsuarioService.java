package com.juratempest.usuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.juratempest.usuarios.model.Usuario;
import com.juratempest.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    
    //AGREGAR COMENTARIOS!!!

    public UsuarioService(
        UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
        
    }

    public Usuario guardar(Usuario usuario){
        if (usuarioRepository.existByemail(usuario.getEmail())){
            throw new RuntimeException("El Email ya esta registrado, intente con otro!");
        }
        if (usuarioRepository.existsByUsername(usuario.getUsername())){
            throw new RuntimeException("El nombre de usuario se encuentra registrado");
        }

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public boolean existsById(Long id){
        return usuarioRepository.existsById(id);
    }

    public Usuario actualizar(Long id ,Usuario usuarioAct){
        Usuario usuario = buscarPorId(id);

        usuario.setUsername(usuarioAct.getUsername());
        usuario.setEmail(usuarioAct.getEmail());
        usuario.setNombreCompleto(usuarioAct.getNombreCompleto());
        usuario.setUserStatus(usuarioAct.isUserStatus());
        usuario.setRol(usuarioAct.getRol());;

        return usuarioRepository.save(usuario);
    }

    public Usuario cambiarEstado(Long id, boolean estado){
        Usuario usuario = buscarPorId(id);
        usuario.setUserStatus(estado);
        return usuarioRepository.save(usuario);
    }

    public void eliminar(Long id){
        if (!usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }

}
