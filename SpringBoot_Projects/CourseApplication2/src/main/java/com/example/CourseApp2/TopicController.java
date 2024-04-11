package com.example.CourseApp2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	//auto wiring the creation of the topicService  
	@Autowired
	TopicService topicService; 
	
	//a basic hello statement 
	@RequestMapping("/hello")
	public String Hello() {
		return "hello";
	}
	
	//getting list of all the available topics
	@RequestMapping("/topic")
	public List<Topic> getAllTopic() {
		return topicService.getAllTopics(); 
	}
	
	//getting a particular topic resource back 
	@RequestMapping("/topic/{id}")
	public Topic getTopicID(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	//add a new Topic 
	@RequestMapping(value = "/topic", method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic); 
	}
	
	//updating a given topic resource
	@RequestMapping(value="/topic/{id}", method = RequestMethod.PUT)
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		topicService.updateTopic(topic); 
	}
	
	//updating a given topic resource
	@RequestMapping(value="/topic/{id}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id); 
	}
	
}
