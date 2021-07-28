package com.franklinti.api.controller;

import java.util.List;

import com.franklinti.api.excecao.MessageResponseDTO;
import com.franklinti.api.model.Usuario;
import com.franklinti.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public MessageResponseDTO salvarUsuario( @RequestBody Usuario usuario){
         return usuarioService.salvar(usuario);
    }

    @PutMapping("{id}")
    public Usuario atualizarUsuario(@RequestBody Usuario novoUsuario,@PathVariable(value="id")Long id){
        return usuarioService.atualizar(novoUsuario, id);
    }
    
    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable(value="id") Long id){
        return usuarioService.getUsuarioId(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable(value = "id")Long id){
        return usuarioService.deletar(id);
    }
}
