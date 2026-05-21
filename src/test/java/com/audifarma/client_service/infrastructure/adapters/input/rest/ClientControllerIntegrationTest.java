package com.audifarma.client_service.infrastructure.adapters.input.rest;

import com.audifarma.client_service.application.dto.AddressRequest;
import com.audifarma.client_service.application.dto.ClientRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateClient() throws Exception {

        ClientRequest request = new ClientRequest(
                "Carlos",
                "Lopez",
                "carlos@example.com",
                "3019999999",
                List.of(
                        new AddressRequest(
                                "Calle 10",
                                "Bogota",
                                "Cundinamarca",
                                "111111"
                        )
                )
        );

        mockMvc.perform(post("/api/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Carlos"))
                .andExpect(jsonPath("$.lastname").value("Lopez"));
    }

    @Test
    void shouldGetAllClients() throws Exception {

        mockMvc.perform(get("/api/clients"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn404WhenClientDoesNotExist() throws Exception {

        mockMvc.perform(get("/api/clients/999"))
                .andExpect(status().isNotFound());
    }
}