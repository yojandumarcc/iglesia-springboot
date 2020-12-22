package com.arqui.ufps.freelancer.controller;

import com.arqui.ufps.freelancer.model.entities.*;
import com.arqui.ufps.freelancer.repository.dao.*;
import com.arqui.ufps.freelancer.utils.Defines;
import com.arqui.ufps.freelancer.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.arqui.ufps.freelancer.utils.Defines.*;
import static com.arqui.ufps.freelancer.utils.Defines.SUCCESS;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PATCH, RequestMethod.PUT })
public class UserController {

	@Autowired
	private IUserDao userDao;

	@GetMapping
	public List<User> list() {
		return userDao.findAll();
	}

	@GetMapping("/{email}")
	public ResponseEntity<Object> getUser(@PathVariable String email) {
		User user = userDao.findByEmail(email);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.ok(new GenericResponse(Defines.FAILED.getSecond(), Defines.FAILED.getFirst()));
		}
	}

	@PatchMapping("/{emailStudent}")
	public GenericResponse setUser(@PathVariable String emailStudent, @RequestBody User user) {
		User userFound = userDao.findByEmail(emailStudent);

		if (userFound == null) {
			return new GenericResponse(FAILED.getSecond(), USER_NOT_FOUND.getSecond(), USER_NOT_FOUND.getFirst());
		}

		userDao.save(userFound);		
		
		return new GenericResponse(SUCCESS.getSecond(), SUCCESS.getFirst());
	}

}
