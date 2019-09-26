package entrySystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrySystem.dao.RegisteredEntrantRepository;
import entrySystem.domain.RegisteredEntrant;

@Service
public class RegisteredEntrantService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private RegisteredEntrantRepository registeredEntrantRepository;

	public void save(RegisteredEntrant registeredEntrant) {
		logger.info("Create new registeredEntrant: " + registeredEntrant);

		registeredEntrantRepository.save(registeredEntrant);
	}

	public RegisteredEntrant findById(Integer id) {
		logger.info("Find registeredEntrant by id: " + id);

		return registeredEntrantRepository.findById(id).get();
	}

	public List<RegisteredEntrant> findAllRegisteredEntrants() {
		logger.info("Find all registeredEntrants");

		return registeredEntrantRepository.findAll();
	}

	public void deleteById(Integer id) {
		logger.info("Delete registeredEntrant by id: " + id);

		registeredEntrantRepository.deleteById(id);
	}
}
