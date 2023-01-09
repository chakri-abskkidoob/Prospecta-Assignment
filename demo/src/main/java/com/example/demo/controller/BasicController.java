package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ResultDTO;
import com.example.demo.entities.Data;
import com.example.demo.entities.Entry;
import com.example.demo.repository.EntryRepo;

@RestController
public class BasicController {
	
	@Autowired(required = true)
	RestTemplate restTemplate;
	
	@Autowired
	private EntryRepo entryRepo;
	

	@GetMapping("/entries/{category}")
	public List<ResultDTO> getdata(@PathVariable String category) {
		Data d = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		entryRepo.saveAll(d.getEntries());
		return d.getEntries().stream()
				.filter(e -> e.getCategory().equalsIgnoreCase(category))
				.map(e -> new ResultDTO(e.getApi(), e.getDescription()))
				.toList();
	}
	
	@PostMapping("save")
	public Entry saveEntry(@RequestBody Entry entry) {
		entryRepo.save(entry);
		return entry;
	}
}
