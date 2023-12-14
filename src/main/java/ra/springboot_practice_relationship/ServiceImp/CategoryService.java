package ra.springboot_practice_relationship.ServiceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.Category;
import ra.springboot_practice_relationship.reponsitory.ICategoryRepository;
import ra.springboot_practice_relationship.service.ICategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) throws NotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy Id"));
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
