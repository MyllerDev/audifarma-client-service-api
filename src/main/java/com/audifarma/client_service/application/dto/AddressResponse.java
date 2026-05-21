package com.audifarma.client_service.application.dto;

public record AddressResponse(
        Long id,
        String street,
        String city,
        String state,
        String postalCode
) {
}