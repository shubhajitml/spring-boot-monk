package com.projects.springbootquickstart.courseapi.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projects.springbootquickstart.courseapi.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@GetMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@PathVariable("topicId") String topicId, @RequestBody Course course) { 
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	@PutMapping("/topics/{topicId}/courses/{id}")
	public void updateCourse(@PathVariable("topicId") String topicId, @PathVariable("id") String id, @RequestBody Course course) { 
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) { 
		courseService.deleteCourse(id);
	}
	
	
}
