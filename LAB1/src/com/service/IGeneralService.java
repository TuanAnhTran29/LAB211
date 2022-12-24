package com.service;

import java.util.List;

public interface IGeneralService<T> {
    public void add(T t);

    public List<T> findAll();

    public void update(T t);

    public void delete(T t);

    public T findById(Long id);

    public List<T> findByName(String name);
}
