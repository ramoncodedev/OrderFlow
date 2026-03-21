package com.ordemflow.ordemFlow.infrastructure.repository;

import com.ordemflow.ordemFlow.infrastructure.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    boolean existsByEmail(String email);
}
