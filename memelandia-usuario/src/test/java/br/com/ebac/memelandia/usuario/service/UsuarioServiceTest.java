package br.com.ebac.memelandia.usuario.service;

import br.com.ebac.memelandia.usuario.entity.Usuario;
import br.com.ebac.memelandia.usuario.exception.UsuarioExistenteException;
import br.com.ebac.memelandia.usuario.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UsuarioServiceTest {


    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;

    @BeforeEach
    void setup() {
        usuario = new Usuario();
        usuario.setNome("Fulano");
        usuario.setEmail("fulano@example.com");
        usuario.setDataCadastro(new Date(System.currentTimeMillis()));
    }

    @Test
    void salvarUsuarioSucesso() {
        when(usuarioRepository.existsByEmail(anyString())).thenReturn(false);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);

        assertNotNull(usuarioSalvo);
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void salvarUsuarioExistente() {
        when(usuarioRepository.existsByEmail(anyString())).thenReturn(true);

        assertThrows(UsuarioExistenteException.class, () -> usuarioService.salvarUsuario(usuario));

        verify(usuarioRepository, times(0)).save(usuario);
    }

    @Test
    void buscarUsuarioPorIdSucesso() {
        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));

        Usuario usuarioEncontrado = usuarioService.buscarUsuarioPorId(1L);

        assertNotNull(usuarioEncontrado);
        assertEquals(usuario.getNome(), usuarioEncontrado.getNome());
    }
}
