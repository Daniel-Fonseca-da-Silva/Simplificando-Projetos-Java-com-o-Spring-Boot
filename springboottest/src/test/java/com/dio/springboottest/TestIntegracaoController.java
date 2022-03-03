package com.dio.springboottest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class TestIntegracaoController {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testIntegracao() throws Exception {

        RequestBuilder requisicao = get("/test");
        MvcResult resultado = mvc.perform(requisicao).andReturn();
        Assertions.assertEquals("Bem-vindo, Daniel", resultado.getResponse().getContentAsString());
    }

    @Test
    public void testIntegracaoComArgumento() throws Exception {
        mvc.perform(get("/test?nome=Daniel"))
                .andExpect((ResultMatcher) content().string("Bem-vindo, Daniel"));
    }

}
