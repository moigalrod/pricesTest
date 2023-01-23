package com.inditex.test.domain.mapper;

import com.inditex.test.domain.Prices;
import com.inditex.test.domain.model.PricesApplyResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricesApplyResponseMapperService extends MapperService<Prices, PricesApplyResponseModel> {

    @Override
    @Mapping(source = "brand.id", target = "brandId" )
    PricesApplyResponseModel toModel(Prices entity);
}
