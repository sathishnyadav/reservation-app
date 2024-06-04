package org.jsp.reservationapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	private String token;
	@Column(nullable = false)
	private String status;
	@OneToMany(mappedBy = "admin")
	@JsonIgnore
	private List<Bus> buses;
}
