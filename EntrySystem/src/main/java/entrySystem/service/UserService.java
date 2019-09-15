package entrySystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import entrySystem.dao.UserRepository;
import entrySystem.domain.User;
import entrySystem.domain.UserRoles;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		user.setRole(UserRoles.ROLE_USER);
		userRepository.save(user);
	}
}
