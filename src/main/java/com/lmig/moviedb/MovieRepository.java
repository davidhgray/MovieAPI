package com.lmig.moviedb;

import com.lmig.moviedb.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
}