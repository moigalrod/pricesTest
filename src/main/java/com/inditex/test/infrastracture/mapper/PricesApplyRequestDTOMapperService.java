package com.inditex.test.infrastracture.mapper;

import com.inditex.test.domain.model.PricesApplyRequestModel;
import com.inditex.test.infrastracture.dto.PricesApplyRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesApplyRequestDTOMapperService extends MapperDTOService<PricesApplyRequestModel, PricesApplyRequestDTO> {
}
