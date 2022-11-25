package com.example.designbookmyshow.repositories;

import com.example.designbookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({
            @QueryHint(name = "javax.persistence.lock.timeout", value = "30000")
    })
    List<ShowSeat> findByIdIn(List<Long> showSeatIds);
    @Override
    ShowSeat save(ShowSeat showSeat);

    @Override
    <S extends ShowSeat> List<S> saveAll(Iterable<S> entities);
}
