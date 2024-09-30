package com.usuario.Test;

import com.usuario.controller.UsuarioController;
import com.usuario.controller.request.vo.RequestFiltroUsuario;
import com.usuario.entity.Usuario;
import com.usuario.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConsultaUsuario() throws Exception {

        RequestFiltroUsuario filtro = new RequestFiltroUsuario();
        filtro.setNome("Leonardo");

        List<Usuario> usuarios = Arrays.asList(
                new Usuario( "Leonardo"),
                new Usuario( "João")
        );


        when(usuarioService.consultaUsuario(filtro)).thenReturn(usuarios);

        mockMvc.perform(get("/api/consulta/0/10")
                        .header("Authorization", "Basic dXNlcjpwYXNzd29yZA==")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Leonardo\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"nome\":\"Leonardo\"},{\"id\":2,\"nome\":\"João\"}]"));
    }
}
