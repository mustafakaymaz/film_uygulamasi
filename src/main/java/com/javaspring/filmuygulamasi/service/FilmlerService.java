package com.javaspring.filmuygulamasi.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.javaspring.filmuygulamasi.entity.Filmler;


public interface FilmlerService {
	List<Filmler> getAllFilmler();
	void saveFilmler(Filmler filmler);
	Filmler getFilmlerById(long id);
	void deleteFilmlerById(long id);
	Page<Filmler> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
		
	
}
