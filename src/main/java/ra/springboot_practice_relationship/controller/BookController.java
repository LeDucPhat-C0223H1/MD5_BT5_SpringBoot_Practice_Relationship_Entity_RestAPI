package ra.springboot_practice_relationship.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.Book;
import ra.springboot_practice_relationship.service.IBookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api.library.com/books")
public class BookController {
    private final IBookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id ) throws NotFoundException {
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) throws NotFoundException {
        Book book = bookService.findById(id);
        bookService.delete(book.getId());
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.save(book), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> editBook(@RequestBody Book book, @PathVariable Long id) throws NotFoundException {
        book.setId(bookService.findById(id).getId());
        return new ResponseEntity<>(bookService.save(book), HttpStatus.OK);
    }

    /******************************************************************************************/


    @PutMapping("/{bookId}/category/{categoryId}")
    public ResponseEntity<Book> addCategory(@PathVariable Long categoryId, @PathVariable Long bookId) throws NotFoundException {
        return new ResponseEntity<>(bookService.addCategoryToBook(categoryId,bookId), HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}/category/{categoryId}")
    public ResponseEntity<Book> removeCategory(@PathVariable Long bookId) throws NotFoundException {
        return new ResponseEntity<>(bookService.removeCategoryFromBook(bookId), HttpStatus.OK);
    }

    @PutMapping("/{bookId}/author/{authorId}")
    public ResponseEntity<Book> addAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        return null;
    }

    @DeleteMapping("/{bookId}/author/{authorId}")
    public ResponseEntity<Book> removeAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        return null;
    }
}
