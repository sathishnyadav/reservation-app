package org.jsp.reservationapi.controller;

import org.jsp.reservationapi.dto.ResponseStructure;
import org.jsp.reservationapi.dto.UserRequest;
import org.jsp.reservationapi.model.User;
import org.jsp.reservationapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody UserRequest userRequest) {
		return userService.saveUser(userRequest);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody UserRequest userRequest,
			@PathVariable int id) {
		return userService.update(userRequest, id);
	}

	@GetMapping("{id}")
	public ResponseEntity<ResponseStructure<User>> saveUser(@PathVariable int id) {
		return userService.findById(id);
	}

	@PostMapping("/verify-by-phone")
	public ResponseEntity<ResponseStructure<User>> verify(@RequestParam long phone, @RequestParam String password) {
		return userService.verify(phone, password);
	}

	@PostMapping("/verify-by-email")
	public ResponseEntity<ResponseStructure<User>> verify(@RequestParam String email, @RequestParam String password) {
		return userService.verify(email, password);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> delete(@PathVariable int id) {
		return userService.delete(id);
	}
}
