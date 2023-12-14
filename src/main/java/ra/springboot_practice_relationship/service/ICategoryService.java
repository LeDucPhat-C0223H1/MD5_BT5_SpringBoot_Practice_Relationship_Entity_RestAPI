package ra.springboot_practice_relationship.service;

import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Long id) throws NotFoundException;
    Category save (Category category);
    void delete(Long id);
}
