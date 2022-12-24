package com.controller;

import com.model.Request;
import com.service.request.IRequestService;
import com.service.request.RequestService;

import java.util.List;

public class RequestController implements IGeneralController<Request> {
    private static IRequestService requestService;

    public RequestController() {
        requestService= new RequestService();
    }

    @Override
    public void add(Request request) {
        requestService.add(request);
    }

    @Override
    public void update(Request request) {
        requestService.update(request);
    }

    @Override
    public void delete(Request request) {
        requestService.delete(request);
    }

    @Override
    public List<Request> findAll() {
        return requestService.findAll();
    }

    @Override
    public Request findById(String id) {
        return requestService.findById(id);
    }

    public Request findByID(int id){
        return requestService.findById(id);
    }

    @Override
    public List<Request> findByName(String name) {
        return null;
    }
}
