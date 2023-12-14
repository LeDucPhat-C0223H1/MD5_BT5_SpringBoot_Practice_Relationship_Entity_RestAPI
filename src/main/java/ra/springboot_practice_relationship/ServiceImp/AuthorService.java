package ra.springboot_practice_relationship.ServiceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.Author;
import ra.springboot_practice_relationship.model.Book;
import ra.springboot_practice_relationship.model.ZipCode;
import ra.springboot_practice_relationship.reponsitory.IAuthorRepository;
import ra.springboot_practice_relationship.reponsitory.IBookRepository;
import ra.springboot_practice_relationship.service.IAuthorService;
import ra.springboot_practice_relationship.service.IZipCodeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {
    private final IAuthorRepository authorRepository;
    private final IZipCodeService zipCodeService;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) throws NotFoundException {
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy id"));
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    /******************************************************************************************/

    @Override
    public Author addZipCodeToAuthor(Long zipCodeId, Long authorId) throws NotFoundException {
        ZipCode zipCode = zipCodeService.findById(zipCodeId);
        Author author = findById(authorId);
        //
        author.setZipCode(zipCode);
        return save(author);
    }

    @Override
    public Author removeZipCodeFromAuthor(Long authorId) throws NotFoundException {
        Author author = findById(authorId);
        author.setZipCode(null);
        return save(author);
    }
}
