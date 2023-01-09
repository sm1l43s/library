package main.com.library.dao;

import java.util.List;

public interface IAuthorDAO<K, E, T> extends IBaseDAO <K, E>{

    List<T> findAllBooksByAuthor(E e);

}
