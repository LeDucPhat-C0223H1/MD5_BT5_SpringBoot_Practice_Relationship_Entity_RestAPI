package ra.springboot_practice_relationship.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.City;
import ra.springboot_practice_relationship.reponsitory.ICityRepository;
import ra.springboot_practice_relationship.service.ICityService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService implements ICityService {
    private final ICityRepository cityRepository;
    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) throws NotFoundException {
        return cityRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy id"));
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }


    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
