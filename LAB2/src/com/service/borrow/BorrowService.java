package com.service.borrow;

import com.model.Borrow;
import com.repo.borrow.BorrowRepo;
import com.repo.borrow.IBorrowRepo;

import java.io.IOException;
import java.util.List;

public class BorrowService implements IBorrowService{
    private static IBorrowRepo borrowRepo= BorrowRepo.getInstance();
    private static List<Borrow> borrowList= null;

    public BorrowService() {
        try {
            borrowList= borrowRepo.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Borrow borrow) {
        borrowList.add(borrow);
        try {
            borrowRepo.writeFile(borrowList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Borrow> findAll() {
        return borrowList;
    }

    @Override
    public void update(Borrow borrow) {
        for (int i = 0; i < borrowList.size(); i++) {
            if (borrowList.get(i).getbID() == (borrow.getbID())){
                borrowList.set(i,borrow);
                break;
            }
        }
        try {
            borrowRepo.writeFile(borrowList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Borrow borrow) {
        borrowList.remove(borrow);
        try {
            borrowRepo.writeFile(borrowList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Borrow findById(String id) {
        return null;
    }

    @Override
    public Borrow findById(int id) {
        Borrow borrow= null;
        for (Borrow b: borrowList) {
            if (b.getbID() == id){
                borrow= b;
                break;
            }
        }
        return borrow;
    }
}
