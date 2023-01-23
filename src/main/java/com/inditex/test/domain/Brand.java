package com.inditex.test.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BRAND")
public class Brand {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre de la cadena es obligatoria")
    @Size(max = 200, message = "El nombre de la cadena debe tener como máximo 200 carácteres")
    @Column(name = "NAME", nullable = false, length = 200)
    private String name;
}
