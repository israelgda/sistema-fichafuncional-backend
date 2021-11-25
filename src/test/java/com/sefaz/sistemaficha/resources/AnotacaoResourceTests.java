package com.sefaz.sistemaficha.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sefaz.sistemaficha.entities.Anotacao;
import com.sefaz.sistemaficha.services.AnotacaoService;
import com.sefaz.sistemaficha.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnotacaoResource.class)
public class AnotacaoResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AnotacaoService service;

    private Long existingId;
    private Long nonExistingId;
    private List list;
    private Anotacao anotacao;
    private PageImpl<Anotacao> page;

    @BeforeEach
    void setUp(){
        existingId = 6L;
        nonExistingId = 498L;
        anotacao = new Anotacao(1L, "teste", "FÉRIAS", new Date());
        page = new PageImpl<>(List.of(anotacao));
        List<Anotacao> list = new ArrayList<>(List.of(anotacao));

        Mockito.when(service
                .findAll((Pageable)ArgumentMatchers.any()))
                .thenReturn(page);

        Mockito.when(service
                .findById(existingId))
                .thenReturn(anotacao);

        Mockito.when(service
                .findById(nonExistingId))
                .thenThrow(ResourceNotFoundException.class);

    }

    @Test
    public void findAllShouldReturnPage() throws Exception {

        ResultActions result =
                mockMvc.perform(get("/anotacoes")
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
    }

    @Test
    public void findByIdShouldReturnAnotacaoWhenIdExists() throws Exception {

        ResultActions result =
                mockMvc.perform(get("/anotacoes/{id}", existingId)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
    }

    @Test
    public void findByIdShouldReturnNotFoundWhenDoesNotExists() throws Exception {

        ResultActions result =
                mockMvc.perform(get("/anotacoes/{id}", nonExistingId)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
    }

}
