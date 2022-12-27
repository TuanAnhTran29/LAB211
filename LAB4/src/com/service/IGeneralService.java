package com.service;

import java.util.List;

public interface IGeneralService<T> {
    void add(T t);
    List<T> findAll();
    void update(T t);
    void delete(T t);
    T findById(Long id);
}
