package com.inditex.test.infrastracture.exceptions;

import com.inditex.test.domain.model.PricesApplyRequestModel;

public class PricesNoResultException extends RuntimeException {

    public PricesNoResultException(PricesApplyRequestModel request) {
        super(String.format("No existe una tarifa para aplicar con la fecha: %s, cadena: %s y producto: %s",
                request.getApplyDate().toString(), request.getBrandId(), request.getProductId()));
    }

}
