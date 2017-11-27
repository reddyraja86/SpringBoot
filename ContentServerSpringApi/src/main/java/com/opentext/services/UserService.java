package com.opentext.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opentext.model.User;
import com.opentext.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) throws Exception {

		User userObj = userRepository.save(user);
		if (userObj == null) {
			// throw new EntityNotFoundException(User.class, "id",
			// user.toString());
			throw new Exception();
		}

		return userObj;
	}

	public User updateUser(User user, Integer id) throws Exception {
		User userObjDB = getUser(id);
		userObjDB.setAge(user.getAge());
		userObjDB.setName(user.getName());

		User userObj = userRepository.save(userObjDB);
		if (userObj == null) {
			// throw new EntityNotFoundException(User.class, "id",
			// user.toString());
			throw new Exception();
		}
		
		return userObj;

	}

	public User getUser(Integer id) throws Exception {

		User userObj = userRepository.findOne(id);
		if (userObj == null) {
			// throw new EntityNotFoundException(User.class, "id",
			// user.toString());
			throw new Exception();
		}
		return userObj;

	}

	public List<User> geAlltUsers() throws Exception {

		List<User> usersList = userRepository.findAll();
		if (usersList == null) {
			// throw new EntityNotFoundException(User.class, "id",
			// user.toString());
			throw new Exception();
		}
		return usersList;

	}

	public void deleteUser(Integer id) throws Exception {

		 userRepository.delete(id);
		
	}

}
