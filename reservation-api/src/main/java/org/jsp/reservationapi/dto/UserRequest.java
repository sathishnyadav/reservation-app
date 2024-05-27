package org.jsp.reservationapi.dto;

import lombok.Data;

@Data
public class UserRequest {
	private String name;
	private long phone;
	private String email;
	private String gender;
	private int age;
	private String password;
}
