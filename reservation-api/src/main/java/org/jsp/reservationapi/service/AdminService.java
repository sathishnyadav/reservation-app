package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.AdminDao;
import org.jsp.reservationapi.dto.AdminRequest;
import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.exception.AdminNotFoundException;
import org.jsp.reservationapi.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(AdminRequest admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		structure.setMessage("Admin saved");
		structure.setData(adminDao.saveAdmin(mapToAdmin(admin)));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(structure);
	}

	public ResponseEntity<ResponseStructure<Admin>> update(Admin admin) {
		Optional<Admin> recAdmin = adminDao.findById(admin.getId());
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (recAdmin.isPresent()) {
			Admin dbAdmin = recAdmin.get();
			dbAdmin.setEmail(admin.getEmail());
			dbAdmin.setName(admin.getName());
			dbAdmin.setGst_number(admin.getGst_number());
			dbAdmin.setPassword(admin.getPassword());
			dbAdmin.setPhone(admin.getPhone());
			dbAdmin.setTravels_name(admin.getTravels_name());
			structure.setData(adminDao.saveAdmin(admin));
			structure.setMessage("Admin Updated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(structure);
		}
		throw new AdminNotFoundException("Cannot Update Admin as Id is Invalid");
	}

	public ResponseEntity<ResponseStructure<Admin>> findById(int id) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		Optional<Admin> dbAdmin = adminDao.findById(id);
		if (dbAdmin.isPresent()) {
			structure.setData(dbAdmin.get());
			structure.setMessage("Admin Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new AdminNotFoundException("Invalid Admin Id");
	}

	public ResponseEntity<ResponseStructure<Admin>> verify(long phone, String password) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		Optional<Admin> dbAdmin = adminDao.verify(phone, password);
		if (dbAdmin.isPresent()) {
			structure.setData(dbAdmin.get());
			structure.setMessage("Verification Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new AdminNotFoundException("Invalid Phone Number or Password");
	}

	public ResponseEntity<ResponseStructure<Admin>> verify(String email, String password) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		Optional<Admin> dbAdmin = adminDao.verify(email, password);
		if (dbAdmin.isPresent()) {
			structure.setData(dbAdmin.get());
			structure.setMessage("Verification Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new AdminNotFoundException("Invalid Email Id or Password");
	}

	public ResponseEntity<ResponseStructure<String>> delete(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Admin> dbAdmin = adminDao.findById(id);
		if (dbAdmin.isPresent()) {
			adminDao.delete(id);
			structure.setData("Admin Found");
			structure.setMessage("Admin deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new AdminNotFoundException("Cannot delete Admin as Id is Invalid");
	}

	public Admin mapToAdmin(AdminRequest request) {
		return Admin.builder().email(request.getEmail()).name(request.getName()).gst_number(request.getGst_number())
				.password(request.getPassword()).travels_name(request.getTravels_name()).phone(request.getPhone())
				.build();
	}
}
