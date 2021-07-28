package com.franklinti.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.SessionAttribute;

import antlr.collections.List;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;

import javax.management.Query;

import com.franklinti.api.model.Usuario;
import com.franklinti.api.repository.UsuarioRepository;

import org.h2.engine.Session;
import org.hibernate.SessionBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioTests {

    @Autowired
    private TestEntityManager entityManager;
   
    @Autowired
    private UsuarioRepository usuarioRepository;
   

   
    @Test
    public void testeSalvarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome("F");
        usuario.setSobrenome("s");
        usuario.setEmail("@outlook.com");
        usuario.setUsuarioNome("F");
        usuario.setSenha("123");
        usuarioRepository.save(usuario);
        entityManager.persist(usuario);
        Assert.assertEquals("F", usuario.getNome());
    }

    @Test
    public void testeDeletarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setId(1l);
        usuarioRepository.delete(usuario);
        Assert.assertNotEquals("1l", usuario.getId());
    }
    @Test
    public void testeAtualizarUsuario(){
        Long id = 1l;
        Usuario usuario = new Usuario(id,"F","S","email","un","123");
        usuarioRepository.save(usuario);
        Assert.assertEquals("F", usuario.getNome());
    }
    @Test
    public void testListaUsuario(){
    
    }
   
}
