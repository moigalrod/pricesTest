package com.inditex.test.infrastracture.mapper;

import com.inditex.test.domain.model.PricesApplyResponseModel;
import com.inditex.test.infrastracture.dto.PricesApplyResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesApplyResponseDTOMapperService extends MapperDTOService<PricesApplyResponseModel, PricesApplyResponseDTO> {
}
