package com.learn.springbootdemo.controller;

import com.learn.springbootdemo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ResponseBody
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public User user(){
        User user = new User("1", "sd", "sd@gmail.com");
        return user;
    }

    @GetMapping("/{id}/{id2}")
    public String pathVariable(@PathVariable("id") String orgId,
                               @PathVariable("id2") String empId){
        return "The given path variable orgId is: " + orgId + ", empId is : " + empId;
    }

    @GetMapping("/requestParam")
    public String requestParams(@RequestParam("name") String fullName,
                                @RequestParam(value = "email", required = false, defaultValue = "") String emailId){
        return "Your name is : " + fullName + " and Email Id is: " + emailId;
    }

    @GetMapping("/{branch}/{student}/course")
    public String courseDetailsWithPathVariableAndRequestParam(@PathVariable("student") String studentName,
                                                               @PathVariable("branch") String branchName,
                                                               @RequestParam(value="email", required = false,defaultValue = "") String email,
                                                               @RequestParam(value="name") String courseName,
                                                               @RequestParam(value = "mark") String mark){
        return "In branch: " + branchName + ", " + studentName + " [emailId:" + email + "], has obtained mark: " + mark + " in the course: " + courseName;
    }



}
