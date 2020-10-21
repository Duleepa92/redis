/**
 * 
 */
package com.epic.redis.demo.repository;

import java.util.Map;

import com.epic.redis.demo.model.User;

/**
 * @author duleepa_w
 *
 */
public interface UserRepository {

	void save(User user);

	Map<String, User> findAll();

	User findById(String id);

	void update(User user);

	void delete(String id);

}
