package org.jsp.reservationapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private long phone;
	@Column(unique = true, nullable = false)
	private String gst_number;
	@Column(nullable = false)
	private String travels_name;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
}
