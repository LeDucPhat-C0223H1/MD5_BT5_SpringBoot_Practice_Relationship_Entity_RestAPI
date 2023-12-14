package ra.springboot_practice_relationship.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.springboot_practice_relationship.ServiceImp.ZipCodeService;
import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.ZipCode;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/zipcodes")
public class ZipCodeController {
    private final ZipCodeService zipCodeService;

    @GetMapping
    public ResponseEntity<List<ZipCode>> getZipcodes() {
        return new ResponseEntity<>(zipCodeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZipCode> getZipcode(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(zipCodeService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ZipCode> deleteZipcode(@PathVariable Long id) throws NotFoundException {
        ZipCode zipCode = zipCodeService.findById(id);
        zipCodeService.delete(zipCode.getId());
        return new ResponseEntity<>(zipCode, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ZipCode> addZipcode(@RequestBody ZipCode zipCode) {
        return new ResponseEntity<>(zipCodeService.save(zipCode), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ZipCode> editZipcode(@RequestBody ZipCode zipCode, @PathVariable Long id) throws NotFoundException {
        zipCode.setId(zipCodeService.findById(id).getId());
        return new ResponseEntity<>(zipCodeService.save(zipCode), HttpStatus.OK);
    }

    /******************************************************************************************/

    @PutMapping("/{zipcodeId}/city/{cityId}")
    public ResponseEntity<ZipCode> addCity(@PathVariable Long cityId, @PathVariable Long zipcodeId) throws NotFoundException {
        return new ResponseEntity<>(zipCodeService.addCityToZipCode(cityId, zipcodeId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ZipCode> deleteCity(@PathVariable Long zipcodeId) throws NotFoundException {
        return new ResponseEntity<>(zipCodeService.setCityToNull(zipcodeId), HttpStatus.OK);
    }
}
