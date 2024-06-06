package org.jsp.reservationapi.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@CreationTimestamp
	private LocalDate dateOfBooking;
	@Column(nullable = false)
	private double cost;
	@Column(nullable = false)
	private String status;
	@Column(nullable = false)
	private int numberOfSeatsBooked;
	@ManyToOne
	@JoinColumn(name = "bus_id")
	@JsonIgnore
	private Bus bus;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
}
