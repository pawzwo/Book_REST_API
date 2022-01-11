package pl.coderslab.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class MockBookService implements BooksService{

    private List<Book> books;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        books.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    @Override
    public List<Book> getList() {return books;}

    @Override
    public Optional<Book> getBook(long id) {
        return books.stream().filter(it->it.getId()==id).findFirst();
    }

    @Override
    public void addBook(Book book) {
        book.setId(getBooks().get(getBooks().size()- 1).getId()+1);
        this.books.add(book);
    }




}
