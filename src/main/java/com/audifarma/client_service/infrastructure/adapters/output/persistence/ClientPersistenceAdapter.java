package com.audifarma.client_service.infrastructure.adapters.output.persistence;

import com.audifarma.client_service.domain.model.Client;
import com.audifarma.client_service.domain.ports.ClientRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClientPersistenceAdapter implements ClientRepositoryPort {

    private final ClientJpaRepository clientJpaRepository;

    public ClientPersistenceAdapter(ClientJpaRepository clientJpaRepository) {
        this.clientJpaRepository = clientJpaRepository;
    }

    @Override
    public Client save(Client client) {
        return clientJpaRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientJpaRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientJpaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        clientJpaRepository.deleteById(id);
    }
}