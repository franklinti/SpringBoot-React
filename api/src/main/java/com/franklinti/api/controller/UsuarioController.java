package com.franklinti.api.controller;

import java.util.List;

import com.franklinti.api.excecao.MessageResponseDTO;
import com.franklinti.api.excecao.ResourceNotFoundException;
import com.franklinti.api.model.Usuario;
import com.franklinti.api.repository.UsuarioRepository;
import com.franklinti.api.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UsuarioController {
    
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuario/salvar")
    public MessageResponseDTO salvarUsuario(Usuario usuario){
         return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping("/usuario/all")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable(value="id") Long id){
        return usuarioService.getUsuario(id);
    }

    @PutMapping("/usuario/{id}")
    public Usuario atualizarUsuario(@RequestBody Usuario novoUsuario,@PathVariable(value="id")Long id){
        return usuarioService.atualizarUsuario(novoUsuario, id);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable(value = "id")Long id){
        return usuarioService.removerUsuario(id);
    }
}
