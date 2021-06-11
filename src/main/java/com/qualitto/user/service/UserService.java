package com.qualitto.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qualitto.user.VO.Department;
import com.qualitto.user.VO.ResponseTemplate;
import com.qualitto.user.entities.User;
import com.qualitto.user.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${services.department.endpoint}")
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
