package com.example.CourseApp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	/*
	 * no need to create a hard coded list of Topics
	 * all the topics will be created and added to the apache DB 
	 * which is an embedded database initialized in the pom.xml file
	 * as a dependency
	 */

	//method to get all topics from the database 
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>(); 
		topicRepository.findAll()
						.forEach(topics::add);
		
		return topics;
	}

	//gets a particular topic from the List of topics in the database
	public Topic getTopic(String id) {
	    return topicRepository.findById(id).orElse(null);
	}

	//adds a topic to the DB
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	//updates the contents of a topic with the new topic body passed
	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
	}

	//deletes a topic from the DB by using its id
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);		
	}


}
