package org.jsp.reservationapi.dto;

import lombok.Data;

@Data
public class AdminResponse {
	private int id;
	private String name;
	private Long phone;
	private String email;
	private String travels_name;
	private String gst_number;

}
