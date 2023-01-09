package main.com.library.dao;

import java.util.List;

public interface IBookDAO<K,T, E> extends IBaseDAO<K, T> {

    List<T> findAllBooksByAuthor(E e);

}
