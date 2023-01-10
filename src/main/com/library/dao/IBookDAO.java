package main.com.library.dao;

import main.com.library.entity.Author;
import main.com.library.entity.Genres;

import java.util.List;

public interface IBookDAO<K,T> extends IBaseDAO<K, T> {

    List<T> findAllBooksByAuthor(Author author);
    List<T> findAllBooksByGenres(Genres genres);

}
