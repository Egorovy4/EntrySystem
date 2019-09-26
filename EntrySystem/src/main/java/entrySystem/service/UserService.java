package entrySystem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import entrySystem.dao.UserRepository;
import entrySystem.domain.User;
import entrySystem.domain.UserRoles;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		logger.info("Create new user: " + user);

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		user.setRole(UserRoles.ROLE_USER);
		userRepository.save(user);
	}

	public User findUserByEmail(String email) {
		logger.info("Find user by email: " + email);

		return userRepository.findByEmail(email).get();
	}

	public User findUserById(Integer id) {
		logger.info("Find user by id: " + id);

		return userRepository.findById(id).get();
	}
}
