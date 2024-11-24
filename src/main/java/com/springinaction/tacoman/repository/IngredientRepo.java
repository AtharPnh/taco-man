package com.springinaction.tacoman.repository;

import com.springinaction.tacoman.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepo extends CrudRepository<Ingredient, String> {
}
