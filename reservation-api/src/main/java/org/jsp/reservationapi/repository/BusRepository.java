package org.jsp.reservationapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.jsp.reservationapi.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRepository extends JpaRepository<Bus, Integer> {
	@Query("select b from Bus b where b.admin.id=?1")
	List<Bus> findByAdminId(int id);

	@Query("select b from Bus b where b.from=?1 and b.to=?2 and b.dateOfDeparture=?3")
	List<Bus> findBuses(String from, String to, LocalDate dateOfDeparture);
}
