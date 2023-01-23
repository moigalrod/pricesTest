package com.inditex.test.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PricesApplyRequestModel {

    private Long brandId;

    private LocalDateTime applyDate;

    private Long productId;

}
