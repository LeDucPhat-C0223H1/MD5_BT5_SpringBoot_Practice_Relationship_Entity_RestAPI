package ra.springboot_practice_relationship.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.Author;
import ra.springboot_practice_relationship.service.IAuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api.library.com/authors")
public class AuthorController {
    private final IAuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAuthors(){
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(authorService.findById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) throws NotFoundException {
        Author author = authorService.findById(id);
        authorService.delete(author.getId());
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorService.save(author), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Author> editAuthor(@RequestBody Author author, @PathVariable Long id) throws NotFoundException {
        author.setId(authorService.findById(id).getId());
        return new ResponseEntity<>(authorService.save(author), HttpStatus.OK);
    }

    /**************************************************************************************/

    @PutMapping("/{authorId}/zipcode/{zipcodeId}")
    private ResponseEntity<Author> addZipcode(@PathVariable Long zipcodeId, @PathVariable Long authorId) throws NotFoundException {
        return new ResponseEntity<>(authorService.addZipCodeToAuthor(zipcodeId, authorId), HttpStatus.OK);
    }

    @DeleteMapping("/{authorId}/zipcode/{zipcodeId}")
    private ResponseEntity<Author> removeZipcode(@PathVariable Long zipcodeId) throws NotFoundException {
        return new ResponseEntity<>(authorService.removeZipCodeFromAuthor(zipcodeId), HttpStatus.OK);
    }
}
