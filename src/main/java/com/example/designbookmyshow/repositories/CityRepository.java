package com.example.designbookmyshow.repositories;

import com.example.designbookmyshow.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    @Override
    City save(City city);
    @Override
    Optional<City> findById(Long id);
}
