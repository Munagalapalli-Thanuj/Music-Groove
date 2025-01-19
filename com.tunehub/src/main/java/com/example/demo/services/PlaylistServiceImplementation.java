package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepositories;

@Service
public class PlaylistServiceImplementation implements PlaylistService {
	
	@Autowired
	PlaylistRepositories repo;
	@Override
	public void addPlaylist(Playlist playlist) {
		// TODO Auto-generated method stub
		repo.save(playlist);
		
	}
	@Override
	public List<Playlist> fetchAllPlaylists() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
}
