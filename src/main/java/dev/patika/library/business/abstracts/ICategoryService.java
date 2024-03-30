package dev.patika.library.business.abstracts;

import dev.patika.library.entities.Category;

import java.util.List;

public interface ICategoryService {
    Category getById(int id);
    Category save(Category category);
    Category update(Category category);
    boolean delete(int id);
    List<Category> getAll();
}
