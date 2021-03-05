package com.techhmr.userservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.techhmr.userservice.VO.Department;
import com.techhmr.userservice.VO.ResponseTemplate;
import com.techhmr.userservice.entities.User;
import com.techhmr.userservice.repo.UserRepository;

@Service
public class UserService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${department.service.endpoint}")
	private String departServiceEndpoint;
	
	
	public User saveUser(User user){
		log.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}
	
	public ResponseTemplate getUserWithDepartment(Long userId){
		log.info("Inside getUserWithDepartment of UserService");
		ResponseTemplate vo = new ResponseTemplate();
		User user = userRepository.findByUserId(userId);
		vo.setUser(user);
		if (user != null) {
			Department department = restTemplate.getForObject(departServiceEndpoint+user.getDepartmentId()+"/", Department.class);
			vo.setDepartment(department);
		}
		return vo;
	}
}
