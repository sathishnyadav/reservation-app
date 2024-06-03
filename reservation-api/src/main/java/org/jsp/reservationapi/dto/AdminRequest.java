package org.jsp.reservationapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminRequest {
	private long phone;
	@Email(message = "Invalid Format")
	private String email;
	@NotBlank(message = "GST Number is mandatory")
	@Size(min = 6, max = 15, message = "GST Number must have 6 to 15 characters")
	private String gst_number;
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotBlank(message = "Travels Name is mandatory")
	private String travels_name;
	@NotBlank(message = "Password is mandatory")
	@Size(min = 4, max = 15, message = "Password length must be between 4 to 15")
	private String password;
}
