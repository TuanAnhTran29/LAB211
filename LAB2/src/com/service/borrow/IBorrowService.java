package com.service.borrow;

import com.model.Borrow;
import com.service.IGeneralService;

public interface IBorrowService extends IGeneralService<Borrow> {
    Borrow findById(int id);
}
