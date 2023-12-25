package com.crudsimples.CrudSimples.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

public record PartnersRecordDto(

        @NotBlank
         String firstname,
        @NotBlank
         String lastname,
         @NotNull
         Integer partnertype,
         @NotNull
         String cpf

) {
}
