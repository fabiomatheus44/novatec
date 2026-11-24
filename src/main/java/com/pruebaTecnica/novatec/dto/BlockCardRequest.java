package com.pruebaTecnica.novatec.dto;
import jakarta.validation.constraints.Size;

public record BlockCardRequest(@NotBlank @Size(max=250) String reason) {

}
