package com.inditex.test.domain.mapper;

import com.inditex.test.domain.Brand;
import com.inditex.test.domain.model.BrandModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapperService extends MapperService<Brand, BrandModel> {
}
