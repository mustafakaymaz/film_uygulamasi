package com.javaspring.filmuygulamasi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaspring.filmuygulamasi.entity.Filmler;



@Repository
public interface FilmlerRepository extends JpaRepository<Filmler, Long>{
  
	@Query(value = "select * from Filmler f where f.ad like %:kelime% or f.tur like %:kelime%", nativeQuery = true)
	List<Filmler> findByKelime(@Param("kelime") String kelime);
}