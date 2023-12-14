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
@RequestMapping("/api/v1/zipCode")
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
        zipCodeService.findById(id);
        return new ResponseEntity<>(zipCodeService.save(zipCode), HttpStatus.OK);
    }
//
//    @PostMapping("/addCity/{cityId}/toZipcode/{zipcodeId}")
//    public ResponseEntity<Zipcode> addCity(@PathVariable  Long cityId,
//                                           @PathVariable  Long zipcodeId) {
//
//    }
//
//    @PostMapping("/deleteCity/{zipcodeId}")
//    public ResponseEntity<Zipcode> deleteCity(@PathVariable  Long zipcodeId) {
//
//    }
}
