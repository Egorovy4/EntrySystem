package entrySystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrySystem.dao.FacultyRepository;
import entrySystem.domain.Faculty;

@Service
public class FacultyService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private FacultyRepository facultyRepository;

	public Faculty save(Faculty faculty) {
		logger.info("Create new faculty: " + faculty);
		
		return facultyRepository.save(faculty);
	}

	public List<Faculty> findAllFaculties() {
		logger.info("Find all faculties");
		
		return facultyRepository.findAll();
	}
	
	public Faculty findFacultyById(Integer id) {
		logger.info("Find faculty by id: " + id);
		
		return facultyRepository.findById(id).get();
	}
}
