package com.example.designbookmyshow.repositories;


import com.example.designbookmyshow.models.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumRepository
        extends JpaRepository<Auditorium, Long> {
}
