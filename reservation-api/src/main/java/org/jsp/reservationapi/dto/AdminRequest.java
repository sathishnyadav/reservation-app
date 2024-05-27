package org.jsp.reservationapi.dto;

import lombok.Data;

@Data
public class AdminRequest {
	private long phone;
	private String email;
	private String gst_number;
	private String name;
	private String travels_name;
	private String password;
}
