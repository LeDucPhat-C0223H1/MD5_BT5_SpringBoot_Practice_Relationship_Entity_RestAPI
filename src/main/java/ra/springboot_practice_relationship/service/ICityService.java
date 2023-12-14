package ra.springboot_practice_relationship.service;

import org.springframework.web.multipart.MultipartFile;
import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();
    City findById(Long id) throws NotFoundException;
    City save (City city);
    void delete(Long id);
}
