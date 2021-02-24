package com.javaspring.filmuygulamasi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.filmuygulamasi.entity.Oyuncular;


@Repository
public interface OyuncularRepository extends JpaRepository<Oyuncular, Long> {

}
