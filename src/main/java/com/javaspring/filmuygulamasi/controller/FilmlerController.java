package com.javaspring.filmuygulamasi.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaspring.filmuygulamasi.entity.Filmler;
import com.javaspring.filmuygulamasi.service.FilmlerService;



@Controller
public class FilmlerController {

	@Autowired
	private FilmlerService filmlerService;
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "ad", "asc", model);		
	}
	
	@GetMapping("/filmFormunuGoster")
	public String yeniFilmFormu(Model model) {
		// form verileni oluşturmak için model oluşturma
		Filmler filmler = new Filmler();
		model.addAttribute("filmler", filmler);
		return "filmEkle";
	}
	@PostMapping("/filmKaydet")
	public String filmKaydet(@ModelAttribute("filmler") Filmler filmler) {
		// filmi veitabanına kayıt oluşturma 
		filmlerService.saveFilmler(filmler);
		return "redirect:/";
	}
	
	@GetMapping("/guncellemeFormunuGoster/{id}")
	public String guncellemeFormunuGoster(@PathVariable ( value = "id") long id, Model model) {
		
		// film verilerini servisten çağırma 
		Filmler filmler = filmlerService.getFilmlerById(id);
		
		// Filmleri, formu önceden doldurmak için bir model özniteliği olarak ayarlama
		model.addAttribute("filmler", filmler);
		return "film-guncelle";
	}
	
	@GetMapping("/filmSilme/{id}")
	public String filmSilme(@PathVariable (value = "id") long id) {
		// film silme çağırma işlemi
		this.filmlerService.deleteFilmlerById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Filmler> page = filmlerService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Filmler> filmListesi = page.getContent();
	
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "null");
		
		if(sortDir != null) {
		model.addAttribute("yeniFilmFormu", pageNo);
		}
		
			model.addAttribute("filmListesi", filmListesi);
		
		return "index";
	}
}
