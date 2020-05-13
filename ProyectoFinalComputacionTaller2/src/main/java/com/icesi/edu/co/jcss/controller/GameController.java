package com.icesi.edu.co.jcss.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateGame;
import com.icesi.edu.co.jcss.model.TsscGame;
import com.icesi.edu.co.jcss.repositories.IRepositoryTopic;
import com.icesi.edu.co.jcss.services.IServiceGame;
import com.icesi.edu.co.jcss.services.IServiceStory;
import com.icesi.edu.co.jcss.services.IServiceTopic;

@Controller
public class GameController {

	IServiceGame serviceGame;
	IServiceStory serviceStory;
	IServiceTopic serviceTopic;

	@Autowired
	public GameController(IServiceGame serviceGame, IServiceStory serviceStory, IServiceTopic serviceTopic) {
		this.serviceGame = serviceGame;
		this.serviceStory = serviceStory;
		this.serviceTopic = serviceTopic;
	}

	@GetMapping("/games/")
	public String indexGame(Model model) {
		model.addAttribute("games", serviceGame.findAll());
		return "games/index";
	}

	@GetMapping("/games/add")
	public String addGame(Model model) {

		model.addAttribute("game", new TsscGame());
		return "games/add-game";
	}

	@PostMapping("/games/add")
	public String saveGame(TsscGame game, Integer id, Integer idTopic, IRepositoryTopic iRepositoryTopic,
			@RequestParam(value = "action", required = true) String action, BindingResult bindingResult)
			throws ExceptionNotCreateGame {

		if (bindingResult.hasErrors()) {
			return "games/add-game";
		}

		if (!action.equals("Cancel"))
			serviceGame.saveGame(game, id, idTopic, iRepositoryTopic);
		return "redirect:/games/";
	}
	
	@GetMapping("/games/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Optional<TsscGame> game = serviceGame.findById(id);
		if (game == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("game", game.get());
		return "games/edit-game";
	}

	@PostMapping("/games/edit/{id}")
	public String updateGame(@PathVariable("id") int id,TsscGame game, Integer idTopic, IRepositoryTopic iRepositoryTopic,
			@RequestParam(value = "action", required = true) String action, BindingResult bindingResult) throws ExceptionNotCreateGame {

		if (bindingResult.hasErrors()) {
			return "games/add-game";
		}

		if (action != null && !action.equals("Cancel")) {
			serviceGame.editGame(game, id, idTopic, iRepositoryTopic);
		}
		return "redirect:/games/";
	}

	@GetMapping("/games/del/{id}")
	public String deleteGame(@PathVariable("id") int id) {
		TsscGame game = serviceGame.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		serviceGame.delete(game);
		return "redirect:/games/";
	}

}
