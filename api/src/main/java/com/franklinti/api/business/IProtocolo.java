package com.franklinti.api.business;

import java.util.List;

import com.franklinti.api.excecao.MessageResponseDTO;
import com.franklinti.api.model.Protocolo;

import org.springframework.http.ResponseEntity;

public interface IProtocolo {

    MessageResponseDTO salvar(Protocolo p);
    Protocolo atualizar(Protocolo p,Long id);
    ResponseEntity<Protocolo> getProtocoloId(Long id);
    ResponseEntity<List<Protocolo>> getAllProtocolos();
    ResponseEntity<Void> deletar(Long id);
    
}
