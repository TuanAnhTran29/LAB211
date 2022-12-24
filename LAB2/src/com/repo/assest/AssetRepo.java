package com.repo.assest;

import com.model.Asset;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AssetRepo implements IAssetRepo, Serializable{
    private static AssetRepo assestRepo= null;
    private static final File file= new File("assest.dat");

    public static AssetRepo getInstance(){
        if (assestRepo == null){
            return new AssetRepo();
        }
        return assestRepo;
    }

    @Override
    public List<Asset> readFile() throws IOException {
        List<Asset> assestList= new ArrayList<>();
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() == 0){
            return new ArrayList<>();
        }
        try {
            InputStream inputStream= new FileInputStream(file);
            ObjectInputStream objectInputStream= new ObjectInputStream(inputStream);
            assestList= (List<Asset>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return assestList;
    }

    @Override
    public void writeFile(List<Asset> assestList) throws IOException, ClassNotFoundException {
        try {
            OutputStream outputStream= new FileOutputStream(file);
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(assestList);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
