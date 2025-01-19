package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Favourite;
import com.example.demo.entities.Song;
import com.example.demo.services.FavouriteService;
import com.example.demo.services.SongService;

@Controller
public class FavouriteController {
	@Autowired
	SongService songService;
	
	@Autowired
	FavouriteService favouriteService;
	
	@GetMapping("/createFavourites")
	public String createFavourites(Model model) {
		List<Song> songList=songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createFavourites";
	}
	
	@PostMapping("/addFavourites")
	public String addPlaylist(@ModelAttribute Favourite favourites) {
		
	
		
		//updating play list table
	favouriteService.addFavourite(favourites);
    
	//updating song table;
	List<Song> songList=favourites.getSongs();
	for(Song s: songList) {
		s.getFavourite().add(favourites);
		//update song object in db
		songService.updateSong(s);
	}
	return "redirect:/createFavourites";
	}
	//Here we are fetching all playlist songs on to the webpage
	@GetMapping("/viewFavourites")
	public String viewFavourites(Model model) {
		//we are creating a list to display all playlist
		List<Favourite> allFavourites= favouriteService.fetchAllFavourites();
		//model is used to get all play lists
		model.addAttribute("allFavourites", allFavourites);
		//we will go to display play lists page when clicked on view playlist
		return "displayFavourites";
	}
	

}
