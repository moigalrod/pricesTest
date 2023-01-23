package com.inditex.test.domain.mapper;

import com.inditex.test.domain.Prices;
import com.inditex.test.domain.model.PricesModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesMapperService extends MapperService<Prices, PricesModel> {
}
