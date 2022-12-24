package com.repo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface ILoadingFile<T>{
    List<T> readFile() throws IOException;
    void writeFile(List<T> t) throws IOException,ClassNotFoundException;
}
