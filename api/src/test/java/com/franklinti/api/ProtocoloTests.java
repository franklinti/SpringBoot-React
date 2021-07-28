package com.franklinti.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import antlr.collections.List;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.xml.crypto.Data;

import com.franklinti.api.model.Protocolo;
import com.franklinti.api.model.Usuario;
import com.franklinti.api.repository.ProtocoloRepository;
import com.franklinti.api.repository.UsuarioRepository;

import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProtocoloTests {

    @Autowired
    private TestEntityManager entityManager;
   
    @Autowired
    private ProtocoloRepository protocoloRepository;
   
    @Test
    public void testeSalvarProtocolo(){
        Protocolo p = new Protocolo();
        Usuario u = new Usuario();
        u.setNome("F");
        p.setCodigo(1l);
        p.setData(new Date());
        p.setTexto("Teste");
        p.setUsuario(u);
        protocoloRepository.save(p);
        entityManager.persist(p);
        Assert.assertEquals("Teste", p.getTexto());
    }

    @Test
    public void testeDeletarProtocolo(){
        Protocolo p = new Protocolo();
        p.setId(1l);
        protocoloRepository.delete(p);
        Assert.assertNotEquals("1l", p.getId());
    }
    @Test
    public void testeAtualizarProtocolo(){
        Usuario u = new Usuario();
        u.setNome("F");
        Date d = new Date();
        Protocolo p = new Protocolo();
        p.setCodigo(1l);
        p.setData(d);
        p.setTexto("texto");
        p.setUsuario(u);
        protocoloRepository.save(p);
        Assert.assertEquals("F", p.getUsuario().getNome());
    }
    @Test
    public void testListaProtocolo(){
      
    }
   
}
