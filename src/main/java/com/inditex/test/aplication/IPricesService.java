package com.inditex.test.aplication;

import com.inditex.test.aplication.common.ICrudService;
import com.inditex.test.aplication.common.IValidationService;
import com.inditex.test.domain.Prices;
import com.inditex.test.domain.model.PricesApplyRequestModel;
import com.inditex.test.domain.model.PricesApplyResponseModel;
import com.inditex.test.domain.model.PricesModel;
import com.inditex.test.infrastracture.dto.PricesApplyRequestDTO;
import com.inditex.test.infrastracture.dto.PricesApplyResponseDTO;

public interface IPricesService extends ICrudService<PricesModel>, IValidationService<Prices> {

    PricesApplyResponseModel applyPrice(PricesApplyRequestModel request);
}
