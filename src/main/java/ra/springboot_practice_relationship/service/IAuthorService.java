package ra.springboot_practice_relationship.service;

import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.Author;
import ra.springboot_practice_relationship.model.Book;

import java.util.List;

public interface IAuthorService {
    List<Author> findAll();
    Author findById(Long id) throws NotFoundException;
    Author save(Author author);
    void delete(Long id);

    /*******************/

    Author addZipCodeToAuthor(Long zipCodeId, Long authorId) throws NotFoundException;
    Author removeZipCodeFromAuthor(Long authorId) throws NotFoundException;

}
