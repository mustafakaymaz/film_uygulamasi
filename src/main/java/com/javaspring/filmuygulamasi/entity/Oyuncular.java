package com.javaspring.filmuygulamasi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "oyuncu")
public class Oyuncular {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long  oyuncuid ;
	
	
	@Column(name = "ad_soyad")
	private String adSoyad;
	
	@Column(name = "rol")
	private String rol;
	
	@ManyToOne
	private Filmler filmler;
	
	public Oyuncular() {
		super();
	}


	public Oyuncular(String adSoyad, String rol) {
		super();
		this.adSoyad = adSoyad;
		this.rol = rol;
	}


	public long getOyuncuid() {
		return oyuncuid;
	}

	
	public void setOyuncuid(long oyuncuid) {
		this.oyuncuid = oyuncuid;
	}

	
	public String getAdSoyad() {
		return adSoyad;
	}

	
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	
	public String getRol() {
		return rol;
	}

	
	public void setRol(String rol) {
		this.rol = rol;
	}
	

}
