package dev.patika.library.api;

import dev.patika.library.business.abstracts.ICategoryService;
import dev.patika.library.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CategoryController {
    @Autowired
    private final ICategoryService service;

    @Autowired
    public CategoryController (ICategoryService categoryService) {
        this.service = categoryService;
    }

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> findAll() {
        return this.service.getAll();
    }

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return this.service.save(category);
    }


    @PutMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public Category update(@RequestBody Category category) {
        return this.service.update(category);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable ("id") int id) {
        this.service.delete(id);
    }

    @GetMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category getById(@PathVariable("id") int id) {
        return this.service.getById(id);
    }
}
