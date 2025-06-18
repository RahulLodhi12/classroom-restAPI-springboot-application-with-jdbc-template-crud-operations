package com.tcs.training.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.training.bean.Learner;
import com.tcs.training.dao.LearnerDao;

@Service
public class LearnerService {
	
	@Autowired
	LearnerDao learnerDao;
		
	public List<Learner> getAllLearners(){
		return learnerDao.getAllLearners();
	}
	
	
	public Learner getLearnerById(@PathVariable int id) {
		return learnerDao.getLearnerById(id);
	}
	
	
	public void addNewLearner(@RequestBody Learner learner) { //@RequestBody -> looking for JSON Data
		learnerDao.addNewLearner(learner);
	}
	
	
	public void updateLearnerById(@PathVariable int id, @RequestBody Learner learner) {
		learnerDao.updateLearnerById(id, learner);
	}
	
	
	public void deleteLearnerById(@PathVariable int id) {
		learnerDao.deleteLearnerById(id);
	}
}
