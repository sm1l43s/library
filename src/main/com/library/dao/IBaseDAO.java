package main.com.library.dao;

import java.util.List;

public interface IBaseDAO <K, T> {
    List<T> findAll();
    T findById(K id);
    boolean delete(T t);
    boolean create(T t);
    T update(T t);
}
