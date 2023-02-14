package com.generation.blogpessoal.repository;

import com.generation.blogpessoal.model.Usuario;
import jakarta.persistence.Table;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start(){

        usuarioRepository.deleteAll();

        usuarioRepository.save(new Usuario(0l, "Joao da Silva", "joao@email.com.br", "13465278", "https://i.imgur.com/FETvs20.jpg"));

        usuarioRepository.save(new Usuario(0L, "Manuela da Silva", "manuela@email.com.br", "13465278", "https://i.imgur.com/NtyGneo.jpg"));

        usuarioRepository.save(new Usuario(0L, "Adriana da Silva", "adriana@email.com.br", "13465278", "https://i.imgur.com/mB3VM2N.jpg"));

        usuarioRepository.save(new Usuario(0L, "Paulo Antunes", "paulo@email.com.br", "13465278", "https://i.imgur.com/JR7kUFU.jpg"));
    }

    @Test
    @DisplayName("Retorna 1 usuario")
    public void deveRetornarUmUsuario(){

        Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br");
        
        assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
    }


    @AfterAll
    public void end(){
        usuarioRepository.deleteAll();
    }

    @Test
    @DisplayName("Retorna 3 usuarios")
    public void deveRetornarTresUsuarios() {

        List<Usuario> ListaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
        assertEquals(3, ListaDeUsuarios.size());
        assertTrue(ListaDeUsuarios.get(0).getNome().equals("Joao da Silva"));
        assertTrue(ListaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
        assertTrue(ListaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));
    }

}
