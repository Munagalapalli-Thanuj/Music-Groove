package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;

@Service
public interface SongService {
	//Adding a song defined here and body is written in song service implementation
	public void addSong(Song song);
	
	//Fetching all song defined here and body is written in song service implementation
	public List<Song> fetchAllSongs();

	public boolean songExists(String name);
	
	public void updateSong(Song song);

	
}
