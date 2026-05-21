package com.audifarma.client_service.infrastructure.adapters.input.rest;

import com.audifarma.client_service.application.dto.ClientRequest;
import com.audifarma.client_service.application.dto.ClientResponse;
import com.audifarma.client_service.application.usecase.ClientUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clients", description = "Client management APIs")
public class ClientController {

    private final ClientUseCase clientUseCase;

    public ClientController(ClientUseCase clientUseCase) {
        this.clientUseCase = clientUseCase;
    }

    @Operation(summary = "Create a new client")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse createClient(
            @Valid @RequestBody ClientRequest request
    ) {

        return clientUseCase.createClient(request);
    }

    @Operation(summary = "Get all clients")
    @GetMapping
    public List<ClientResponse> getAllClients() {

        return clientUseCase.getAllClients();
    }

    @Operation(summary = "Get client by ID")
    @GetMapping("/{id}")
    public ClientResponse getClientById(
            @PathVariable Long id
    ) {

        return clientUseCase.getClientById(id);
    }

    @Operation(summary = "Update client")
    @PutMapping("/{id}")
    public ClientResponse updateClient(
            @PathVariable Long id,
            @Valid @RequestBody ClientRequest request
    ) {

        return clientUseCase.updateClient(id, request);
    }

    @Operation(summary = "Delete client")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(
            @PathVariable Long id
    ) {

        clientUseCase.deleteClient(id);
    }
}