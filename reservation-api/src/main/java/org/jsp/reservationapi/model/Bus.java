package org.jsp.reservationapi.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "bus_name", nullable = false)
	private String name;
	@Column(nullable = false, name = "bus_number")
	private String busNumber;
	@Column(nullable = false, name = "date_of_departure")
	private LocalDate dateOfDeparture;
	@Column(nullable = false, name = "from_location")
	private String from;
	@Column(nullable = false, name = "to_location")
	private String to;
	@Column(nullable = false, name = "number_of_seats")
	private int numberOfSeats;
	@Column(nullable = false, name = "available_seats")
	private int availableSeats;
	@Column(nullable = false, name = "cost_per_seat")
	private double costPerSeat;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;
	@OneToMany(mappedBy = "bus")
	private List<Ticket> bookedTickets;
}
