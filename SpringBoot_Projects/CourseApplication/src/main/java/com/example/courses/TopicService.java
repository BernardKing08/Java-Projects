package com.example.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	//creating an object of the Topic class 
	List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("Java", "JakartaEE", "Learning about spring"),
													 		new Topic("Flutter", "Flutter and dart", "Learn about flutter and dart")));

	public List<Topic> getAllTopics() {
		return topics; 
	}

	public Topic getTopic(String id) {
	    return topics.stream()
	                 .filter(t -> t.getId().equals(id))
	                 .findFirst()
	                 .orElse(null); // Handle the case when no topic is found with the given ID
	}

	public void addTopic(Topic topic) {
		topics.add(topic); 
	}

	public void updateTopic(String id, Topic topic) {
		for(int i = 0; i < topics.size(); i++) {
			if(topics.get(i).getId().equalsIgnoreCase(id)) {
				topics.set(i, topic);
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equalsIgnoreCase(id));
		
	}

	
	
	
	

}
