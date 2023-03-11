package com.ada.demo.controllers;

import com.ada.demo.model.Car;
import com.ada.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/cars")
public class CarRestController {
    @Autowired
    private CarService carService;

    @PostMapping("/save")
    public Car save(@RequestBody Car car){
        return carService.save(car);
    }

    @GetMapping("/all")
    public List<Car> findAll(){
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Long id){
        return carService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        carService.deleteById(id);
    }

    @PostMapping("/edit")
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody Car car) {

        if (car.getName() == null) {
            System.out.println("O nome não pode ser nulo!");
            return ResponseEntity.badRequest().body("O nome não pode ser nulo!");
        }

        car.setId(id);

        try {
            carService.save(car);
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

        return ResponseEntity.ok(car);

    }

}
