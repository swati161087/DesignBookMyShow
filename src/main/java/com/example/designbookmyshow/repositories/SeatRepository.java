package com.example.designbookmyshow.repositories;

import com.example.designbookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository
        extends JpaRepository<Seat, Long> {
}
