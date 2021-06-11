package com.qualitto.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qualitto.user.VO.Department;
import com.qualitto.user.VO.ResponseTemplate;
import com.qualitto.user.entities.User;
import com.qualitto.user.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${services.department.endpoint}")
	private String deptSrvUrl;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public ResponseTemplate findById(Long id) {
		Optional<User> usrOpt = userRepository.findById(id);
		if (usrOpt.isPresent()) {
			User usr = usrOpt.get();
			Department department = restTemplate.getForObject(deptSrvUrl + usr.getDeptId() + "/", Department.class);
			return ResponseTemplate.builder().user(usr).department(department).build();
		} else {
			return null;
		}
	}
}
