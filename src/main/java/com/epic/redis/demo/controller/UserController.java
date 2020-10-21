/**
 * 
 */
package com.epic.redis.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epic.redis.demo.model.User;
import com.epic.redis.demo.repository.UserRepository;

/**
 * @author duleepa_w
 *
 */

@RestController
@RequestMapping("/redis/user")
public class UserController {

	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@GetMapping("/add/{id}/{name}")
	public User userAdd(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		userRepository.save(new User(id, name, 50000));
		return userRepository.findById(id);

	}

	@GetMapping("/update/{id}/{name}")
	public User userUpdate(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		userRepository.update(new User(id, name, 50000));
		return userRepository.findById(id);

	}

	@GetMapping("/delete/{id}")
	public Map<String, User> userUpdate(@PathVariable("id") final String id) {
		userRepository.delete(id);
		return userRepository.findAll();

	}

	@GetMapping("/all")
	public Map<String, User> findAll() {
		return userRepository.findAll();
	}
}
