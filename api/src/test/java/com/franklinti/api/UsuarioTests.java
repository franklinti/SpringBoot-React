package com.franklinti.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import antlr.collections.List;

import static org.junit.jupiter.api.Assertions.assertAll;

import com.franklinti.api.model.Usuario;
import com.franklinti.api.repository.UsuarioRepository;

import org.assertj.core.api.ListAssert;
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
        usuario.setNome("Franklin");
        usuario.setSobrenome("Silva");
        usuario.setEmail("franklint@outlook.com");
        usuario.setUsuarioNome("Franklin");
        usuario.setSenha("123");
        usuarioRepository.save(usuario);
        entityManager.persist(usuario);
        Assert.assertEquals("Franklin", usuario.getNome());
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
        Usuario usuario = new Usuario();
        usuario.setNome("F");
        usuario.setSobrenome("S");
        usuario.setEmail("@outlook.com");
        usuario.setUsuarioNome("");
        usuario.setSenha("123");
        usuarioRepository.save(usuario);
        entityManager.persist(usuario);
        Assert.assertEquals("F", usuario.getNome());
    }
    @Test
    public void testListaUsuario(){
        ListAssert<Usuario> u = (ListAssert<Usuario>) usuarioRepository.findAll();
        Assert.assertNotNull(u); 
    }
   
}
