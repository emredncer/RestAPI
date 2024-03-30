package dev.patika.library.business.concretes;

import dev.patika.library.business.abstracts.IBookService;
import dev.patika.library.dao.BookRepo;
import dev.patika.library.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements IBookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Book getById(int id) {
        return this.bookRepo.findById(id).orElseThrow();
    }

    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public Book update(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public void delete(int id) {
        this.bookRepo.delete(this.getById(id));
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepo.findAll();
    }
}
