package com.inditex.test.infrastracture.mapper;

import java.util.List;

public interface MapperDTOService<M, D> {
    D toDTO(M model);

    M toModel(D dto);

    List<D> toListDTO(List<M> model);

    List<M> toListModel(List<D> dto);
}
