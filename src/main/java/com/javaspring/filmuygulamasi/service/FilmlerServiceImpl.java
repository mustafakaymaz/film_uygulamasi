package com.javaspring.filmuygulamasi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javaspring.filmuygulamasi.entity.Filmler;
import com.javaspring.filmuygulamasi.repository.FilmlerRepository;



@Service
public class FilmlerServiceImpl implements FilmlerService {

	@Autowired
	private FilmlerRepository filmlerRepository;



	@Override
	public List<Filmler> getAllFilmler() {
		return filmlerRepository.findAll();
	}
	
	
	

	@Override
	public void saveFilmler(Filmler filmler) {
		this.filmlerRepository.save(filmler);
	}

	@Override
	public Filmler getFilmlerById(long id) {
		Optional<Filmler> optional = filmlerRepository.findById(id);
		Filmler filmler = null;
		if (optional.isPresent()) {
			filmler = optional.get();
		} else {
			throw new RuntimeException(" Film id bulunamadi :: " + id);
		}
		return filmler;
	}

	@Override
	public void deleteFilmlerById(long id) {
		this.filmlerRepository.deleteById(id);
	}

	@Override
	public Page<Filmler> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.filmlerRepository.findAll(pageable);
	}
	
}

