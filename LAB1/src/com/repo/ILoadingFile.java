package com.repo;

import java.io.IOException;
import java.util.List;

public interface ILoadingFile<T> {
    public List<T> readFile() throws IOException;

    public void writeFile(List<T> t) throws IOException, ClassNotFoundException;

}
