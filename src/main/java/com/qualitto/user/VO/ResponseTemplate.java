package com.qualitto.user.VO;

import com.qualitto.user.entities.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTemplate {
	private User user;
	private Department department;
}