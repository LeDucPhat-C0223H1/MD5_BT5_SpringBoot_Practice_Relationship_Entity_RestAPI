package ra.springboot_practice_relationship.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.springboot_practice_relationship.model.ZipCode;

public interface IZipCodeRepository extends JpaRepository<ZipCode,Long> {
}
