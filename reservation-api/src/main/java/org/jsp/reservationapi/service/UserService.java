package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.UserDao;
import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.dto.UserRequest;
import org.jsp.reservationapi.exception.UserNotFoundException;
import org.jsp.reservationapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(UserRequest userRequest) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("User saved");
		structure.setData(userDao.saveUser(mapToUser(userRequest)));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(structure);
	}

	public ResponseEntity<ResponseStructure<User>> update(UserRequest userRequest, int id) {
		Optional<User> recUser = userDao.findById(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			User dbUser = mapToUser(userRequest);
			dbUser.setId(id);
			structure.setData(userDao.saveUser(dbUser));
			structure.setMessage("User Updated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(structure);
		}
		throw new UserNotFoundException("Cannot Update User as Id is Invalid");
	}

	public ResponseEntity<ResponseStructure<User>> findById(int id) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> dbUser = userDao.findById(id);
		if (dbUser.isPresent()) {
			structure.setData(dbUser.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new UserNotFoundException("Invalid User Id");
	}

	public ResponseEntity<ResponseStructure<User>> verify(long phone, String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> dbUser = userDao.verify(phone, password);
		if (dbUser.isPresent()) {
			structure.setData(dbUser.get());
			structure.setMessage("Verification Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new UserNotFoundException("Invalid Phone Number or Password");
	}

	public ResponseEntity<ResponseStructure<User>> verify(String email, String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> dbUser = userDao.verify(email, password);
		if (dbUser.isPresent()) {
			structure.setData(dbUser.get());
			structure.setMessage("Verification Succesfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new UserNotFoundException("Invalid Email Id or Password");
	}

	public ResponseEntity<ResponseStructure<String>> delete(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<User> dbUser = userDao.findById(id);
		if (dbUser.isPresent()) {
			userDao.delete(id);
			structure.setData("User Found");
			structure.setMessage("User deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new UserNotFoundException("Cannot delete User as Id is Invalid");
	}

	private User mapToUser(UserRequest userRequest) {
		return User.builder().email(userRequest.getEmail()).name(userRequest.getName()).phone(userRequest.getPhone())
				.gender(userRequest.getGender()).age(userRequest.getAge()).password(userRequest.getPassword()).build();
	}
}
