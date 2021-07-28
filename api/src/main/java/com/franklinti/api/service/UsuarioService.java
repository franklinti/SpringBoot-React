package com.franklinti.api.service;

import java.util.List;

import com.franklinti.api.business.IUsuario;
import com.franklinti.api.excecao.MessageResponseDTO;
import com.franklinti.api.excecao.ResourceNotFoundException;
import com.franklinti.api.model.Usuario;
import com.franklinti.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UsuarioService  implements IUsuario{

    private UsuarioRepository usuarioRepository;
    
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public MessageResponseDTO salvar(Usuario u) {
        Usuario user = usuarioRepository.save(u);
        return MessageResponseDTO.builder()
        .message("OK"+user.getEmail())
        .build();
    }
    @Override
    public Usuario atualizar(Usuario u,@PathVariable(value = "id") Long id) {
        return this.usuarioRepository.findById(id)
        .map(usuario ->{
            usuario.setNome(u.getNome());
            usuario.setSobrenome(u.getSobrenome());
            usuario.setEmail(u.getEmail());
            usuario.setUsuarioNome(u.getUsuarioNome());
            usuario.setSenha(u.getSenha());
            return this.usuarioRepository.save(usuario);
        })
        .orElseGet(()->{
            u.setId(id);
            return this.usuarioRepository.save(u);
        });
    }
    @Override
    public ResponseEntity<Usuario> getUsuarioId(Long id) {
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Usuario nao encontrado")
            
        );
        return ResponseEntity.ok().body(usuario);
    }
    @Override
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(
            this.usuarioRepository.findAll()
        );
    }
    @Override
    public ResponseEntity<Void> deletar(Long id) {
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Usuario com esse id: "+id+ " nao encontrado")
        );
        this.usuarioRepository.delete(usuario);
        return ResponseEntity.ok().build();
    }
    
}
