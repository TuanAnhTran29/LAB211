package com.controller;

import com.model.Borrow;
import com.service.borrow.BorrowService;
import com.service.borrow.IBorrowService;

import java.util.List;

public class BorrowController implements IGeneralController<Borrow>{
    private static IBorrowService borrowService;

    public BorrowController() {
        borrowService= new BorrowService();
    }

    @Override
    public void add(Borrow borrow) {
        borrowService.add(borrow);
    }

    @Override
    public void update(Borrow borrow) {
        borrowService.update(borrow);
    }

    @Override
    public void delete(Borrow borrow) {
        borrowService.delete(borrow);
    }

    @Override
    public List<Borrow> findAll() {
        return borrowService.findAll();
    }

    @Override
    public Borrow findById(String id) {
        return borrowService.findById(id);
    }

    @Override
    public List<Borrow> findByName(String name) {
        return null;
    }
}
