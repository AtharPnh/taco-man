package com.springinaction.tacoman.repository;

import com.springinaction.tacoman.entity.TacoOrder;
import com.springinaction.tacoman.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacoOrderRepo extends CrudRepository<TacoOrder, Long> {

   List<TacoOrder> findByUsersOrderByPlacedAtDesc(User user, Pageable pageable);
}
