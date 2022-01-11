package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BooksService {

    List<Book> getList();

    Optional <Book> getBook(long id);

    void addBook(Book book);

    void removeBook(long id);

    Book updateBook(Book book);



}
