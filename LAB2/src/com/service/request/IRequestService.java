package com.service.request;

import com.model.Request;
import com.service.IGeneralService;

public interface IRequestService extends IGeneralService<Request> {
    Request findById(int id);
}
