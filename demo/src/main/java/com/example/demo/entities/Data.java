package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data {
	private int count;
	private List<Entry> entries;
	
	
}
