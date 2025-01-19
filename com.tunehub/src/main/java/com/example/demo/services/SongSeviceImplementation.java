package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepositories;

@Service
public class SongSeviceImplementation implements SongService{

	@Autowired
	SongRepositories repo;
	@Override
	//Here add song method is used to add a song in front end
	public void addSong(Song song) {
		// TODO Auto-generated method stub
		repo.save(song);
		
	}
	@Override
	//fetching all songs present in the database
	public List<Song> fetchAllSongs() {
		return repo.findAll();
	}
	@Override
	public boolean songExists(String name) {
		Song song=repo.findByName(name);
		if(song==null) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public void updateSong(Song song) {
		// TODO Auto-generated method stub
		repo.save(song);
		
	}
	

}
