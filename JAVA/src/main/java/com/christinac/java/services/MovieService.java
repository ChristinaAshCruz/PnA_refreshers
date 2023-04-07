package com.christinac.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christinac.java.models.Movie;
import com.christinac.java.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;
	
	public List<Movie> findAll(){
		return movieRepo.findAll();
	}
}
