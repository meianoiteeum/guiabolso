package br.com.guiabolso.controller;

import br.com.guiabolso.modelo.Usuario;
import br.com.guiabolso.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = {"test"})
public class UsuarioControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private UsuarioRepository repo = new UsuarioRepository();

    private final String url = "usuario";

    @Test
    public void should_ReturnListTransactions_When_GetEndpointListTransactions() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/{url}/{uid}/transactions",url, 1000)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
