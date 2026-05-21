package com.audifarma.client_service.application.usecase;

import com.audifarma.client_service.application.dto.*;
import com.audifarma.client_service.domain.model.Address;
import com.audifarma.client_service.domain.model.Client;
import com.audifarma.client_service.domain.ports.ClientRepositoryPort;
import com.audifarma.client_service.infrastructure.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public ClientUseCase(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    public ClientResponse createClient(ClientRequest request) {

        Client client = new Client();
        client.setName(request.name());
        client.setLastname(request.lastname());
        client.setEmail(request.email());
        client.setPhone(request.phone());

        if (request.addresses() != null) {
            request.addresses().forEach(addressRequest -> {

                Address address = new Address();

                address.setStreet(addressRequest.street());
                address.setCity(addressRequest.city());
                address.setState(addressRequest.state());
                address.setPostalCode(addressRequest.postalCode());

                client.addAddress(address);
            });
        }

        Client savedClient = clientRepositoryPort.save(client);

        return mapToResponse(savedClient);
    }






    public ClientResponse updateClient(Long id, ClientRequest request) {

        Client client = clientRepositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        client.setName(request.name());
        client.setLastname(request.lastname());
        client.setEmail(request.email());
        client.setPhone(request.phone());

        Client updatedClient = clientRepositoryPort.save(client);

        return mapToResponse(updatedClient);
    }

    public void deleteClient(Long id) {

        clientRepositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        clientRepositoryPort.deleteById(id);
    }




    public List<ClientResponse> getAllClients() {

        return clientRepositoryPort.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public ClientResponse getClientById(Long id) {

        Client client = clientRepositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        return mapToResponse(client);
    }

    private ClientResponse mapToResponse(Client client) {

        List<AddressResponse> addresses = client.getAddresses()
                .stream()
                .map(address -> new AddressResponse(
                        address.getId(),
                        address.getStreet(),
                        address.getCity(),
                        address.getState(),
                        address.getPostalCode()
                ))
                .toList();

        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getLastname(),
                client.getEmail(),
                client.getPhone(),
                addresses
        );
    }
}