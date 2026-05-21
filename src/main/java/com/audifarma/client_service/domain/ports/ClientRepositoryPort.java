package com.audifarma.client_service.domain.ports;

import com.audifarma.client_service.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {

    Client save(Client client);

    List<Client> findAll();

    Optional<Client> findById(Long id);

    void deleteById(Long id);
}