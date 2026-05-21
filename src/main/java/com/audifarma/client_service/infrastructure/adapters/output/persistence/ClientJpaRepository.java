package com.audifarma.client_service.infrastructure.adapters.output.persistence;

import com.audifarma.client_service.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<Client, Long> {
}