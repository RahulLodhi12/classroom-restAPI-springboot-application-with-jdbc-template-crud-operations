package com.tcs.training.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.training.bean.Learner;

@Repository
public class LearnerDao {

	// Act as DataBase -> Act as static DataBase
//	List<Learner> learners = new ArrayList<Learner>(Arrays.asList(new Learner(11,"rahul","java"),
//			new Learner(12,"mohit","c++"),
//			new Learner(14,"rohit","php")));

	// Real DB -> These 3 below lines for JDBC Template ->
	//Flow of Code-> application.properties creates bean of "DataSource" and spring guess what you need(auto-config) then create bean of "JdbcTemplate", then inject the "JdbcTemplate" bean
	@Autowired //field injection
	JdbcTemplate jdbcTemplate;

//	DataSource dataSource;
//
//	@Autowired
//	void setDataSource(DataSource dataSource) { // inject the bean of "DataSource" from application.properties -> application.properties file create the bean of "DataSource"
//		System.out.println(dataSource);
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
	// ----------------X--------------X---------------------X

	public List<Learner> getAllLearners() {
		String query = "select * from learner";

		// Block lambda
		List<Learner> allLearners = jdbcTemplate.query(query, (ResultSet rs, int row) -> {
			return new Learner(rs.getInt("id"), rs.getString("name"), rs.getString("skills"));
		});

//		This below line also works: Expression lambda
//		List<Learner> allLearners = jdbcTemplate.query(query, (ResultSet rs, int row)->
//		new Learner(rs.getInt("id"),rs.getString("name"),rs.getString("skills")) //Java automatically add the "return" to the statement.
//		);

		return allLearners; // fetching from getter methods.
	}

	public Learner getLearnerById(@PathVariable int id) {
		// search logic
		String query = "select * from learner where id=?";

		// Block lambda
		Learner learnerObj = jdbcTemplate.queryForObject(query, (ResultSet rs, int row) -> {
			return new Learner(rs.getInt("id"), rs.getString("name"), rs.getString("skills"));
		}, id);

		// This below line also works: Expression lambda
//		 Learner learnerObj = jdbcTemplate.queryForObject(query, (ResultSet rs, int row)->
//		 new Learner(rs.getInt("id"),rs.getString("name"),rs.getString("skills"))
//		 ////Java automatically add the "return" to the statement.
//		 ,id);

		return learnerObj;
	}

	public void addNewLearner(@RequestBody Learner learner) { // @RequestBody -> looking for JSON Data
		// adding logic
		String query = "insert into learner(id,name,skills) values(?,?,?)";

		jdbcTemplate.update(query, learner.getId(), learner.getName(), learner.getSkills());
	}

	public void updateLearnerById(@PathVariable int id, @RequestBody Learner learner) {
		// update logic
		String query = "update learner set name=?, skills=? where id=?";

		jdbcTemplate.update(query, learner.getName(), learner.getSkills(), learner.getId());

	}

	public void deleteLearnerById(@PathVariable int id) {
		// delete logic
		String query = "delete from learner where id=?";

		jdbcTemplate.update(query, id);
	}
}
