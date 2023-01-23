package com.inditex.test.aplication.common;

import java.util.List;

public interface ICrudService<T> {

    public List<T> findAll();

    public T findById(Long id);

    public void delete(Long id);

    public T create(T obj);

    public T update(T obj);

}
