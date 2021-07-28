package com.franklinti.api.business;

import java.util.List;

import com.franklinti.api.excecao.MessageResponseDTO;
import com.franklinti.api.model.Usuario;

import org.springframework.http.ResponseEntity;

public interface IUsuario {
    
    MessageResponseDTO salvar(Usuario u);
    Usuario atualizar(Usuario u,Long id);
    ResponseEntity<Usuario> getUsuarioId(Long id);
    ResponseEntity<List<Usuario>> getAllUsuarios();
    ResponseEntity<Void> deletar(Long id);
}
