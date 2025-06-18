package com.tcs.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.training.bean.Learner;
import com.tcs.training.service.LearnerService;

@RestController
@RequestMapping("/api/v1.0")
public class LearnerController {

	@Autowired
	LearnerService learnerService;
	
	@GetMapping("/learners")
	public List<Learner> getAllLearners(){
		return learnerService.getAllLearners(); 
	}
	
	@GetMapping("/learners/{id}")
	public Learner getLearnerById(@PathVariable int id) {
		return learnerService.getLearnerById(id);
	}
	
	@PostMapping("/learners")
	public void addNewLearner(@RequestBody Learner learner) {
		learnerService.addNewLearner(learner);
	}
	
	@PutMapping("/learners/{id}")
	public void updateLearnerById(@PathVariable int id, @RequestBody Learner learner) {
		learnerService.updateLearnerById(id, learner);
	}
	
	@DeleteMapping("/learners/{id}")
	public void deleteLearnerById(@PathVariable int id) {
		learnerService.deleteLearnerById(id);
	}
	
}
