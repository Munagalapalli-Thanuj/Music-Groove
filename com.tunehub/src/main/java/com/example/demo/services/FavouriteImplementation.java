package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Favourite;
import com.example.demo.repositories.FavouriteRepositories;

@Service
public class FavouriteImplementation implements FavouriteService{

	@Autowired
	FavouriteRepositories repo;
	@Override
	public void addFavourite(Favourite favourite) {
		repo.save(favourite);
		
	}

	@Override
	public List<Favourite> fetchAllFavourites() {
		return repo.findAll();
	}

}
