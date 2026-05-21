package com.audifarma.client_service.application.usecase;

import com.audifarma.client_service.application.dto.ClientRequest;
import com.audifarma.client_service.application.dto.ClientResponse;
import com.audifarma.client_service.domain.model.Client;
import com.audifarma.client_service.domain.ports.ClientRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientUseCaseTest {

    @Mock
    private ClientRepositoryPort clientRepositoryPort;

    @InjectMocks
    private ClientUseCase clientUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateClient() {

        ClientRequest request = new ClientRequest(
                "Juan",
                "Perez",
                "juan@gmail.com",
                "3001234567",
                List.of()
        );

        Client client = new Client();
        client.setId(1L);
        client.setName("Juan");
        client.setLastname("Perez");
        client.setEmail("juan@gmail.com");
        client.setPhone("3001234567");

        when(clientRepositoryPort.save(any(Client.class)))
                .thenReturn(client);

        ClientResponse response = clientUseCase.createClient(request);

        assertNotNull(response);
        assertEquals("Juan", response.name());
        assertEquals("Perez", response.lastname());

        verify(clientRepositoryPort, times(1))
                .save(any(Client.class));
    }

    @Test
    void shouldGetAllClients() {

        Client client = new Client();
        client.setId(1L);
        client.setName("Juan");
        client.setLastname("Perez");
        client.setEmail("juan@gmail.com");
        client.setPhone("3001234567");

        when(clientRepositoryPort.findAll())
                .thenReturn(List.of(client));

        List<ClientResponse> responses = clientUseCase.getAllClients();

        assertFalse(responses.isEmpty());
        assertEquals(1, responses.size());
    }
}