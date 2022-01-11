package pl.coderslab.controllers;

import org.springframework.web.bind.annotation.*;

import pl.coderslab.model.Book;
import pl.coderslab.model.JsonResponse;
import pl.coderslab.service.BooksService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    BooksService booksService;

    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return booksService.getList();
    }

    @PostMapping("")
    public JsonResponse addBook(@RequestBody Book book) {
        booksService.addBook(book);
        return new JsonResponse("new book", book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return booksService.getBook(id).orElseThrow();
    }

    @PutMapping("")
    @ResponseBody
    public JsonResponse updateBook(@RequestBody Book book) {
        booksService.updateBook(book);
        return new JsonResponse(("updated book:"), book);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable long id){
        booksService.removeBook(id);
    }



    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }

}