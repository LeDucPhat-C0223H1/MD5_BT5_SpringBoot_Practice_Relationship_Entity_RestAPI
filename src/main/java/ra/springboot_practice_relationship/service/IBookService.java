package ra.springboot_practice_relationship.service;

import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Long id) throws NotFoundException;
    Book save (Book book);
    void delete(Long id);

    /*******************/

    Book addCategoryToBook(Long categoryId, Long bookId) throws NotFoundException;
    Book removeCategoryFromBook(Long bookId) throws NotFoundException;

    Book addAuthorToBook(Long authorId, Long bookId) throws NotFoundException;
    Book removeAuthorFromBook(Long authorId, Long bookId) throws NotFoundException;
}
