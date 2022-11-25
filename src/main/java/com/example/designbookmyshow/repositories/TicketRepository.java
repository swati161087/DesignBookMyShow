package com.example.designbookmyshow.repositories;

import com.example.designbookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Override
    public Ticket save(Ticket entity);
}
