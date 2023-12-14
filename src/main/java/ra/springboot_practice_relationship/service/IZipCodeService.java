package ra.springboot_practice_relationship.service;

import org.springframework.stereotype.Repository;
import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.ZipCode;

import java.util.List;

@Repository
public interface IZipCodeService {
    List<ZipCode> findAll();
    ZipCode findById(Long id) throws NotFoundException;
    ZipCode save (ZipCode zipCode);
    void delete(Long id);

    /***************************************************/

    ZipCode addCityToZipCode(Long cityId, Long zipCodeId) throws NotFoundException;

    ZipCode setCityToNull(Long id) throws NotFoundException;
}
