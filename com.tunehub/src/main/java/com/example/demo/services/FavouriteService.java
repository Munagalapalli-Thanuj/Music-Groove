package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Favourite;

@Service
public interface FavouriteService {
	
	public void addFavourite(Favourite favourite);

	public List<Favourite> fetchAllFavourites();

}
