package com.springinaction.tacoman.repository;

import com.springinaction.tacoman.entity.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepo extends CrudRepository<Taco, Long> {
}
