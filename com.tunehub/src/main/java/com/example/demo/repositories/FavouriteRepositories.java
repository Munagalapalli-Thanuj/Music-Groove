package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Favourite;


public interface FavouriteRepositories extends JpaRepository<Favourite, Integer> {

}
