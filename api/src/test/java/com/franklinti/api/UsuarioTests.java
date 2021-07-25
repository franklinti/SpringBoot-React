package com.franklinti.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franklinti.api.model.Usuario;
import com.franklinti.api.repository.UsuarioRepository;

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
        Usuario usuario = new Usuario("Franklin",
        "Silva","franklinti@outlook.com",
        "Franklin","123");
        usuarioRepository.save(usuario);
        entityManager.persist(usuario);
        Assert.assertEquals("Franklin", usuario.getNome());
        
    }

   
}
