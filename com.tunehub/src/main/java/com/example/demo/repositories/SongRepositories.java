package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Song;

public interface SongRepositories extends JpaRepository<Song, Integer>{

	public Song findByName(String name);
   // this is repository for song

	
}
