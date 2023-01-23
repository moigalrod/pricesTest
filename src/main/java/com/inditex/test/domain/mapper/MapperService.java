package com.inditex.test.domain.mapper;

import java.util.List;

public interface MapperService<E, M> {
    E toEntity(M model);

    M toModel(E entity);

    List<M> toListModel(List<E> entity);

    List<E> toListEntity(List<M> model);


}
