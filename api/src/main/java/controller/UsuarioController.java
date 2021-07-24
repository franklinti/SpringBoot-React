package controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/usuario/salvar")
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    @GetMapping("/usuario/all")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return ResponseEntity.ok(
            this.usuarioRepository.findAll();
        );
    }
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable(value="id") Long id){
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Usuario nao encontrado")
        );
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("usuario/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable(value = "id")Long id){
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Usuario com esse id: "+id+ " nao encontrado")
        );
        this.usuarioRepository.delete(usuario);
        return ResponseEntity.ok().build();
    }
}
