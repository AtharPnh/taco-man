package com.springinaction.tacoman.repository;

import com.springinaction.tacoman.entity.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepo extends JpaRepository<Taco, Long> {
}
