package ra.springboot_practice_relationship.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.springboot_practice_relationship.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
