package com.ada.demo.controllers;
import com.ada.demo.model.Car;
import com.ada.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("/cars")
    public String getAllCars(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @PostMapping("/cars")
    public String addCar(@RequestParam("name") String name, @RequestParam("description") String description){
        Car car = new Car();
        car.setName(name);
        car.setDescription(description);
        carService.save(car);

        return "redirect:cars";
    }

    @GetMapping("add-car")
    public String createCar(){
        return "add-cars";
    }

    @PostMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable("id") Long id) {
        carService.deleteById(id);
        return "cars";
    }

    @PostMapping("/search")
    public String searchFor(@RequestParam("name") String name, Model model){
        List<Car> cars = carService.queryByName(name);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
