package com.franklinti.api.service;

import java.util.List;
import java.util.Optional;

import com.franklinti.api.business.IProtocolo;
import com.franklinti.api.excecao.MessageResponseDTO;
import com.franklinti.api.excecao.ResourceNotFoundException;
import com.franklinti.api.model.Protocolo;
import com.franklinti.api.repository.ProtocoloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProtocoloService implements IProtocolo {

    @Autowired
    private ProtocoloRepository protocoloRepository;

    public ProtocoloService(ProtocoloRepository protocoloRepository){
        this.protocoloRepository = protocoloRepository;
    }

    @Override
    public MessageResponseDTO salvar(Protocolo p) {
        Protocolo protocolo = protocoloRepository.save(p);
        return MessageResponseDTO.builder()
        .message("OK"+protocolo.getId())
        .build();
    }

    @Override
    public Protocolo atualizar(@RequestBody Protocolo p,@PathVariable(value = "id")Long id) {
        return this.protocoloRepository.findById(id)
        .map(proto ->{
            proto.setCodigo(p.getCodigo());
            proto.setData(p.getData());
            proto.setTexto(p.getTexto());
            proto.setUsuario(p.getUsuario());
            return this.protocoloRepository.save(proto);
        }).orElseGet(()->{
            p.setId(id);
            return this.protocoloRepository.save(p);
        });
    }

    @Override
    public ResponseEntity<Protocolo> getProtocoloId(Long id) {
           Protocolo protocolo = this.protocoloRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Protocolo nao encontrado")
            
        );
        return ResponseEntity.ok().body(protocolo);
    }

    @Override
    public ResponseEntity<List<Protocolo>> getAllProtocolos() {
        return ResponseEntity.ok(
            this.protocoloRepository.findAll()
        );
        
    }

    @Override
    public  ResponseEntity<Void> deletar(@PathVariable(value = "id")Long id) {
        Protocolo protocolo = this.protocoloRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Protocolo com esse id"+id+"nao encontrado")
        );

       this.protocoloRepository.delete(protocolo);
       return ResponseEntity.ok().build();
        
    }
    
  
}
