package entrySystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrySystem.dao.RegisteredEntrantRepository;
import entrySystem.domain.RegisteredEntrant;

@Service
public class RegisteredEntrantService {

	@Autowired
	private RegisteredEntrantRepository registeredEntrantRepository;

	public void save(RegisteredEntrant statement) {
		registeredEntrantRepository.save(statement);
	}

	public RegisteredEntrant findById(Integer id) {
		return registeredEntrantRepository.findById(id).get();
	}

	public List<RegisteredEntrant> findAllRegisteredEntrants() {
		return registeredEntrantRepository.findAll();
	}
}
