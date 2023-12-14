package ra.springboot_practice_relationship.ServiceImp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.ZipCode;
import ra.springboot_practice_relationship.reponsitory.IZipCodeRepository;
import ra.springboot_practice_relationship.service.IZipCodeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZipCodeService implements IZipCodeService {
    private final IZipCodeRepository zipCodeRepository;
    @Override
    public List<ZipCode> findAll() {
        return zipCodeRepository.findAll();
    }

    @Override
    public ZipCode findById(Long id) throws NotFoundException {
        return zipCodeRepository.findById(id).orElseThrow(() -> new NotFoundException("Không tìm thấy id"));
    }

    @Override
    public ZipCode save(ZipCode zipCode) {
        return zipCodeRepository.save(zipCode);
    }

    @Override
    public void delete(Long id) {
        zipCodeRepository.deleteById(id);
    }
}
