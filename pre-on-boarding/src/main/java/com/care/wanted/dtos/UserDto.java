package com.care.wanted.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserDto {
	private int userNum;
	private String userId;
	private String password;
}
