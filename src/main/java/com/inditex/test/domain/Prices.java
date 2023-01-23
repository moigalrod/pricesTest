package com.inditex.test.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class Prices {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private Brand brand;

    @NotNull(message = "La fecha inicio de precio tarifa indicado es obligatoria")
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @NotNull(message = "La fecha fin de precio tarifa indicado es obligatoria")
    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    private Long priceList;

    @NotNull(message = "El identificador de producto es obligatorio")
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Max(value = 10, message = "La prioridad no puede ser mayor de 10")
    @Min(value = 0, message = "La prioridad no puede ser negativa")
    @Column(name = "PRIORITY")
    private Integer priority;

    @DecimalMin(value = "0.0", message = "El precio no puede ser negativo")
    @Digits(integer = 10, fraction = 2)
    @NotNull(message = "El precio final de venta es obligatorio")
    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @NotEmpty(message = "La iso de la moneda es obligatorio")
    @Size(max = 5, message = "La iso de la moneda debe tener como máximo 5 carácteres")
    @Column(name = "CURR", nullable = false, length = 5)
    private String currency;
}
