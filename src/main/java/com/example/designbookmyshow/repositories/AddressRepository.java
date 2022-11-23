package com.example.designbookmyshow.repositories;

import com.example.designbookmyshow.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    @Override
    Address save(Address address);
}
