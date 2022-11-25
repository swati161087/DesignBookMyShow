package com.example.designbookmyshow.repositories;

import com.example.designbookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {
    @Override
    <S extends Show> S save(S entity);

    @Override
    Optional<Show> findById(Long aLong);
}
