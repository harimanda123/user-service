package com.qualitto.user.VO;

import com.qualitto.user.entities.User;

import lombok.Data;

@Data
public class ResponseTemplate {
	private User user;
	private Department department;
}