package com.franklinti.api.controller;

import java.util.List;

import com.franklinti.api.excecao.MessageResponseDTO;
import com.franklinti.api.model.Protocolo;
import com.franklinti.api.service.ProtocoloService;
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
@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/api/v1/protocolo")
public class ProtocoloController {

    private ProtocoloService protocoloService;

    @Autowired
    public ProtocoloController(ProtocoloService protocoloService){
        this.protocoloService = protocoloService;
    }
   
    @PostMapping
    public MessageResponseDTO salvar(@RequestBody Protocolo p) {
        return  protocoloService.salvar(p);   
    }

    @PutMapping("{id}")
    public Protocolo atualizar(@RequestBody Protocolo p,@PathVariable(value="id")Long id) {
        return protocoloService.atualizar(p,id);
    }

    @GetMapping("{id}")
    public ResponseEntity<Protocolo> getProtocoloId(@PathVariable(value="id") Long id) {
        return protocoloService.getProtocoloId(id);
    }

    @GetMapping
    public ResponseEntity<List<Protocolo>> getAllProtocolos() {
        return protocoloService.getAllProtocolos();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarProtocolo(@PathVariable (value = "id")Long id) {
     return  protocoloService.deletar(id);
    
    }
    
}
