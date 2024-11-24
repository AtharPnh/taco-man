package com.springinaction.tacoman.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "tacos")
@Entity
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
@RequiredArgsConstructor
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;
    private Date createdAt = new Date();
    @NotNull
    @Size(min=1, message="You must choose at least 1 ingredient")
    @ManyToMany()
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

}
