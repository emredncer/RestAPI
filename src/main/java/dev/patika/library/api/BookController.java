package dev.patika.library.api;

import dev.patika.library.business.abstracts.IBookService;
import dev.patika.library.dto.BookSaveRequest;
import dev.patika.library.dto.BookSaveRespond;
import dev.patika.library.entities.Author;
import dev.patika.library.entities.Book;
import dev.patika.library.entities.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class BookController {

    @Autowired
    private final IBookService service;

    @Autowired
    private ModelMapper _mapper;

    @Autowired
    public BookController(IBookService bookService) {
        service = bookService;
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<BookSaveRespond> getAll() {
        List<BookSaveRespond> bookSaveRespondList = this.service.findAll().stream().map(
                book -> this.modelMapper.map(book,BookSaveRespond.class)
        ).collect(Collectors.toList());
        return bookSaveRespondList;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody BookSaveRequest bookSaveRequest) {
        Book newBook = this.service.map(bookSaveRequest,Book.class);

        return this.service.save(newBook);
    }

    @PutMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public Book update(@RequestBody Book book) {
        return this.service.update(book);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable("id") int id) {
        this.service.delete(id);
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getById(@PathVariable("id") int id) {
        return this.bookService.getById(id);
    }
}
