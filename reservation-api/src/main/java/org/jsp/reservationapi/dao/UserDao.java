package org.jsp.reservationapi.dao;

import java.util.Optional;

import org.jsp.reservationapi.model.User;
import org.jsp.reservationapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	public Optional<User> verify(long phone, String password) {
		return userRepository.findByPhoneAndPassword(phone, password);
	}

	public Optional<User> verify(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public void delete(int id) {
		userRepository.deleteById(id);
	}

	public Optional<User> findByToken(String token) {
		return userRepository.findByToken(token);
	}
}
