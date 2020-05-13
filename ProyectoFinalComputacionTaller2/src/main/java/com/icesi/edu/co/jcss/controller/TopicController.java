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
import com.icesi.edu.co.jcss.exceptions.ExceptionNotCreateTopic;
import com.icesi.edu.co.jcss.model.TsscGame;
import com.icesi.edu.co.jcss.model.TsscTopic;
import com.icesi.edu.co.jcss.repositories.IRepositoryTopic;
import com.icesi.edu.co.jcss.services.IServiceGame;
import com.icesi.edu.co.jcss.services.IServiceStory;
import com.icesi.edu.co.jcss.services.IServiceTopic;

@Controller
public class TopicController {

	IServiceTopic serviceTopic;

	@Autowired
	public TopicController(IServiceTopic serviceTopic) {
		this.serviceTopic = serviceTopic;
	}

	@GetMapping("/topics/")
	public String indexApp(Model model) {
		model.addAttribute("topics", serviceTopic.findAll());
		return "topics/index";
	}

	@GetMapping("/topics/add")
	public String addTopic(Model model) {

		model.addAttribute("topic", new TsscTopic());
		return "topics/add-topic";
	}

	@PostMapping("/topics/add")
	public String saveTopic(TsscTopic topic, Integer id, @RequestParam(value = "action", required = true) String action,
			BindingResult bindingResult) throws ExceptionNotCreateGame, ExceptionNotCreateTopic {

		if (bindingResult.hasErrors()) {
			return "topics/add-topic";
		}

		if (!action.equals("Cancel"))
			serviceTopic.saveTopic(topic, id);
		return "redirect:/topics/";
	}

	@GetMapping("/topics/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Optional<TsscTopic> topic = serviceTopic.findById(id);
		if (topic == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("topic", topic.get());
		return "topics/edit-topic";
	}

	@PostMapping("/topics/edit/{id}")
	public String updateTopic(@PathVariable("id") int id, TsscTopic topic, @RequestParam(value = "action", required = true) String action,
			BindingResult bindingResult) throws ExceptionNotCreateGame, ExceptionNotCreateTopic {

		if (bindingResult.hasErrors()) {
			return "topics/add-topic";
		}

		if (action != null && !action.equals("Cancel")) {
			serviceTopic.editTopic(topic, id);
		}
		return "redirect:/topics/";
	}

	@GetMapping("/topics/del/{id}")
	public String deleteTopic(@PathVariable("id") int id) {
		TsscTopic topic = serviceTopic.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		serviceTopic.delete(topic);
		return "redirect:/topics/";
	}

}
