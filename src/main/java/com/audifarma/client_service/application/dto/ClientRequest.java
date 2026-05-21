package com.audifarma.client_service.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ClientRequest(

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Lastname is required")
        String lastname,

        @Email(message = "Invalid email")
        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Phone is required")
        String phone,

        @Valid
        List<AddressRequest> addresses
) {
}