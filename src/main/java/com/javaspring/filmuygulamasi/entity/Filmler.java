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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filmler")
public class Filmler {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ad")
	private String ad;
	
	@Column(name = "yayin_yili")
	private String yayinYili;
	
	@Column(name = "tur")
	private String tur;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "dil_secenekleri")
	private String dilSecenekleri;
	
	@Column(name = "aciklama")
	private String aciklama;
	
	@OneToMany(mappedBy = "filmler")
	private List<Oyuncular> oyuncular;
	
	public Filmler() {
		
	}


	public Filmler(String ad, String yayinYili, String tur, String model, String dilSecenekleri, String aciklama) {
		super();
		this.ad = ad;
		this.yayinYili = yayinYili;
		this.tur = tur;
		this.model = model;
		this.dilSecenekleri = dilSecenekleri;
		this.aciklama = aciklama;
	}
	
	
	public String getAciklama() {
		return aciklama;
	}

	
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getDilSecenekleri() {
		return dilSecenekleri;
	}
	
	public void setDilSecenekleri(String dilSecenekleri) {
		this.dilSecenekleri = dilSecenekleri;
	}
	
	public String getAcaiklama() {
		return aciklama;
	}
	
	public void setAcaiklama(String acaiklama) {
		this.aciklama = acaiklama;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getAd() {
		return ad;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getYayinYili() {
		return yayinYili;
	}
	
	public void setYayinYili(String yayinYili) {
		this.yayinYili = yayinYili;
	}
	
	public String getTur() {
		return tur;
	}
	
	public void setTur(String tur) {
		this.tur = tur;
	}
	
}
	