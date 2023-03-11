package com.ada.demo.services;

import com.ada.demo.model.Car;
import com.ada.demo.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository movieRepository;

    public Car save(Car movie) {
        return movieRepository.save(movie);
    }

    public List<Car> findAll() {
        return movieRepository.findAll();
    }

    public Car findByName(String name) {
        return movieRepository.findByName(name);
    }

    public Car findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Car> queryByName(String name){
        return movieRepository.queryByName(name);
    }
}
