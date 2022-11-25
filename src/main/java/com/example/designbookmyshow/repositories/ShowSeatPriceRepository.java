package com.example.designbookmyshow.repositories;

import com.example.designbookmyshow.models.ShowSeatPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowSeatPriceRepository extends JpaRepository<ShowSeatPrice,Long> {
    Optional<ShowSeatPrice> findShowSeatPriceByShow(Long id);
}
