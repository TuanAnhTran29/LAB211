package com.controller;

import java.util.List;

public interface IGeneralController<T> {
    void add(T t);

    void update(T t);

    void delete(T t);

    List<T> findAll();

    T findById(String id);

    List<T> findByName(String name);
}
