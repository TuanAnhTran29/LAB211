package com.service.assest;

import com.model.Asset;
import com.repo.assest.AssetRepo;
import com.repo.assest.IAssetRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AssetService implements IAssetService {
    private static IAssetRepo assestRepo= AssetRepo.getInstance();
    private static List<Asset> assestList= null;

    public AssetService() {
        try {
            assestList= assestRepo.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Asset assest) {
        assestList.add(assest);
        try {
            assestRepo.writeFile(assestList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Asset> findAll() {
        return assestList;
    }

    @Override
    public void update(Asset assest) {
        for (int i = 0; i < assestList.size(); i++) {
            if (assestList.get(i).getAssetsID().equals(assest.getAssetsID())){
                assestList.set(i,assest);
                break;
            }
        }
        try {
            assestRepo.writeFile(assestList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Asset assest) {
        assestList.remove(assest);
        try {
            assestRepo.writeFile(assestList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Asset findById(String id) {
        Asset assest= null;
        for (Asset asset : assestList) {
            if (asset.getAssetsID().equals(id)) {
                assest = asset;
                break;
            }
        }
        return assest;
    }

    @Override
    public List<Asset> findByName(String name) {
        List<Asset> assets= new ArrayList<>();
        for (Asset asset : assestList) {
            if (asset.getName().contains(name)) {
                assets.add(asset);
            }
        }
        return assets;
    }
}
