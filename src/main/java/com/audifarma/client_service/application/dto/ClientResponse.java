package com.audifarma.client_service.application.dto;

import java.util.List;

public record ClientResponse(
        Long id,
        String name,
        String lastname,
        String email,
        String phone,
        List<AddressResponse> addresses
) {
}