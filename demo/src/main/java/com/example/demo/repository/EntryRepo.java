package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Entry;

@Repository
public interface EntryRepo extends JpaRepository<Entry, Integer>{

}
