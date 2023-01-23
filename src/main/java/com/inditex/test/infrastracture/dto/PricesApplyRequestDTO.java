package com.inditex.test.infrastracture.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PricesApplyRequestDTO {

    @NotNull(message = "La cadena es obligatoria.")
    private Long brandId;

    @NotNull(message = "La fecha de aplicación es obligatoria.")
    private LocalDateTime applyDate;

    @NotNull(message = "El identificador de producto es obligatorio.")
    private Long productId;

}
