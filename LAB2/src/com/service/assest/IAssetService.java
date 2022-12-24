package com.service.assest;

import com.model.Asset;
import com.service.IGeneralService;

import java.util.List;

public interface IAssetService extends IGeneralService<Asset> {
    List<Asset> findByName(String name);
}
