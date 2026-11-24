package com.pruebaTecnica.novatec.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record IssueCardRequest(
 @NotBlank @Pattern(regexp="^[0-9]{6}$", message="productId debe contener exactamente 6 dígitos") String productId,
 @NotBlank @Size(max=120) String holderName
) {

}
