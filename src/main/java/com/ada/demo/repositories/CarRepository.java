package com.ada.demo.repositories;

import com.ada.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByName(String name);

    List<Car> queryByName(String name);

}
