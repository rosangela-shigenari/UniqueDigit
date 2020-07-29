package com.inter.desafiodigitounico.repositories;

import com.inter.desafiodigitounico.entities.NumberSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<NumberSequence, Integer> {
}
