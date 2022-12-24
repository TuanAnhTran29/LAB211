package com.controller;

import java.util.List;

interface GeneralController<T> {
    void add(T t);

    void update(T t);

    void delete(T t);

    List<T> findAll();

    T findById(Long id);

    List<T> findByName(String name);
}
