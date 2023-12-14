package ra.springboot_practice_relationship.ServiceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.Book;
import ra.springboot_practice_relationship.model.Category;
import ra.springboot_practice_relationship.reponsitory.IBookRepository;
import ra.springboot_practice_relationship.service.IAuthorService;
import ra.springboot_practice_relationship.service.IBookService;
import ra.springboot_practice_relationship.service.ICategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {
    private final IBookRepository iBookRepository;
    private final ICategoryService categoryService;
    private final IAuthorService authorService;
    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(Long id) throws NotFoundException {
        return iBookRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy Id"));
    }

    @Override
    public Book save(Book book) {
        return iBookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        iBookRepository.deleteById(id);
    }

    @Override
    public Book addCategoryToBook(Long categoryId, Long bookId) throws NotFoundException {
        Category category = categoryService.findById(categoryId);
        Book book = findById(bookId);
        //
        book.setCategory(category);
        return save(book);
    }

    @Override
    public Book removeCategoryFromBook(Long bookId) throws NotFoundException {
        Book book = findById(bookId);
        book.setCategory(null);
        return save(book);
    }

    @Override
    public Book addAuthorToBook(Long authorId, Long bookId) throws NotFoundException {
//        Author author = authorService.findById(authorId);
//        Book book = findById(bookId);
//        //
//        book.setAuthorList());
//        return save(book);
        return null;
    }

    @Override
    public Book removeAuthorFromBook(Long bookId) throws NotFoundException {
        Book book = findById(bookId);
        book.setAuthorList(null);
        return save(book);
    }
}
