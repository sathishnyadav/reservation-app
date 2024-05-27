package org.jsp.reservationapi.dto;

import org.springframework.context.annotation.Primary;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Primary
public class AdminRequest {
	@NotBlank(message = "Name is mandatory")
	private String name;
	private Long phone;
	@Email(message = "Invalid Email Format")
	private String email;
	@NotBlank(message = "Travels Name is mandatory")
	private String travels_name;
	@NotBlank(message = "Password is mandatory")
	private String password;
	@NotBlank(message = "Gst Number is mandatory")
	private String gst_number;

}
