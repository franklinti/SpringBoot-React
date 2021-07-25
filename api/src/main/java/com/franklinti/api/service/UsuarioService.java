package com.franklinti.api.service;

import java.util.List;

import com.franklinti.api.excecao.MessageResponseDTO;
import com.franklinti.api.excecao.ResourceNotFoundException;
import com.franklinti.api.model.Usuario;
import com.franklinti.api.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    public MessageResponseDTO salvarUsuario(Usuario usuario){
        Usuario user = usuarioRepository.save(usuario);
        return MessageResponseDTO.builder()
        .message("OK"+user.getEmail())
        .build();
    }

    public ResponseEntity<List<Usuario>> getUsuarios(){
        return ResponseEntity.ok(
            this.usuarioRepository.findAll()
        );
    }
    
    public ResponseEntity<Usuario> getUsuario(@PathVariable(value="id") Long id){
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Usuario nao encontrado")
            
        );
        return ResponseEntity.ok().body(usuario);
    }

    public Usuario atualizarUsuario(Usuario novoUsuario,@PathVariable(value = "id")Long id){
        return this.usuarioRepository.findById(id)
        .map(usuario ->{
            usuario.setNome(novoUsuario.getNome());
            usuario.setSobrenome(novoUsuario.getSobrenome());
            usuario.setEmail(novoUsuario.getEmail());
            usuario.setUsuarioNome(novoUsuario.getUsuarioNome());
            usuario.setSenha(novoUsuario.getSenha());
            return this.usuarioRepository.save(usuario);
        })
        .orElseGet(()->{
            novoUsuario.setId(id);
            return this.usuarioRepository.save(novoUsuario);
        });
    }

    public ResponseEntity<Void> removerUsuario(@PathVariable(value = "id")Long id){
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Usuario com esse id: "+id+ " nao encontrado")
        );
        this.usuarioRepository.delete(usuario);
        return ResponseEntity.ok().build();
    }
    
}
