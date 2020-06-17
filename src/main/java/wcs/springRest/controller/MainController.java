package wcs.springRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wcs.springRest.entity.Book;
import wcs.springRest.repository.BookRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> index(){

        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Book show(@PathVariable int id){

        Optional<Book> optionalBook = bookRepository.findById((long) id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        return null;
    }

    @PostMapping("/book/search")
    public List<Book> search(@RequestBody Map<String, String> body){

        String searchTerm = body.get("text");
        return bookRepository.findByTitleContainsOrDescriptionContains(searchTerm, searchTerm);
    }

    @PostMapping("/books/")
    public Book create(@RequestBody Book book){

        return bookRepository.save(book);
    }

    @PutMapping("/book/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book){

        Book bookToUpdate = bookRepository.findById((long) id).get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setDescription(book.getDescription());
        return bookRepository.save(bookToUpdate);
    }

    @DeleteMapping("book/{id}")
    public boolean delete(@PathVariable int id){

        bookRepository.deleteById((long) id);
        return true;
    }

}
