package com.example.designbookmyshow.repositories;

import com.example.designbookmyshow.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Long> {
    Theater save(Theater theater);
}
