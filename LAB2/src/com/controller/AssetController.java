package com.controller;

import com.model.Asset;
import com.service.assest.AssetService;
import com.service.assest.IAssetService;

import java.util.List;

public class AssetController implements IGeneralController<Asset> {
    private static IAssetService assetService;

    public AssetController() {
        assetService= new AssetService();
    }

    @Override
    public void add(Asset asset) {
        assetService.add(asset);
    }

    @Override
    public void update(Asset asset) {
        assetService.update(asset);
    }

    @Override
    public void delete(Asset asset) {
        assetService.delete(asset);
    }

    @Override
    public List<Asset> findAll() {
        return assetService.findAll();
    }

    @Override
    public Asset findById(String id) {
        return assetService.findById(id);
    }

    @Override
    public List<Asset> findByName(String name) {
        return assetService.findByName(name);
    }
}
