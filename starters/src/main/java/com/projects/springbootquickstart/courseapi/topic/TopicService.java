package com.projects.springbootquickstart.courseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("id-1", "Spring", "spring framework"),
//			new Topic("id-2", "Spring MVC", "mvc"),
//			new Topic("id-3", "Spring Boot", "boot")
//			));

	public List<Topic> getAllTopics(){
//		return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
					   .forEach(topics::add);
		return topics;
		
	}
	
	public Topic getTopic(String id) {
//		return topics.stream()
//					 .filter(t -> t.getId().equals(id))
//					 .findFirst()
//					 .get();
		return topicRepository.findById(id).get();
		
	}
	
	public void addTopic(Topic topic) {
//		topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		
//		topics.stream()
//		  	  .map(t -> t.getId().equals(id) ? topic : t);
		
//		List<Topic> topicsNew = topics.stream()
//					                  .map(t -> t.getId().equals(id) ? topic : t)
//					                  .collect(Collectors.toList());
//		topics = topicsNew;
		
		
//		for(int i = 0; i < topics.size(); ++i) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//			}
//		}
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
//		topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}

}
