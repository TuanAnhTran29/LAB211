package com.service.request;

import com.model.Request;
import com.repo.request.IRequestRepo;
import com.repo.request.RequestRepo;

import java.io.IOException;
import java.util.List;

public class RequestService implements IRequestService{
    private static List<Request> requestList= null;
    private static IRequestRepo requestRepo= RequestRepo.getInstance();

    public RequestService() {
        try {
            requestList= requestRepo.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Request request) {
        requestList.add(request);
        try {
            requestRepo.writeFile(requestList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Request> findAll() {
        return requestList;
    }

    @Override
    public void update(Request request) {
        for (int i = 0; i < requestList.size(); i++) {
            if (requestList.get(i).getrID() == (request.getrID())){
                requestList.set(i,request);
                break;
            }
        }
        try {
            requestRepo.writeFile(requestList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Request request) {
        requestList.remove(request);
        try {
            requestRepo.writeFile(requestList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Request findById(String id) {
        return null;
    }

    @Override
    public Request findById(int id) {
        Request request= null;
        for (int i = 0; i < requestList.size(); i++) {
            if (requestList.get(i).getrID() == id){
                request= requestList.get(i);
            }
        }
        return request;
    }
}
