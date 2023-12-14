package ra.springboot_practice_relationship.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.springboot_practice_relationship.exception.NotFoundException;
import ra.springboot_practice_relationship.model.City;
import ra.springboot_practice_relationship.service.ICityService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/city")
public class CityController {
    private final ICityService cityService;

    @GetMapping
    public ResponseEntity< List<City> > getCities() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(cityService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id) throws NotFoundException {
        City city = cityService.findById(id);
        cityService.delete(city.getId());
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK );
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> editCity(@RequestBody City city, @PathVariable Long id) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }
}
