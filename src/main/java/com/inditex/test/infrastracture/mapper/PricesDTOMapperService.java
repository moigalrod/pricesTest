package com.inditex.test.infrastracture.mapper;

import com.inditex.test.domain.model.PricesModel;
import com.inditex.test.infrastracture.dto.PricesDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesDTOMapperService extends MapperDTOService<PricesModel, PricesDTO> {

}
