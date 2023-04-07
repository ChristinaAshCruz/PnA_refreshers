package com.christinac.java.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.christinac.java.models.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
	
	@Override
	public List<Movie> findAll();
}
