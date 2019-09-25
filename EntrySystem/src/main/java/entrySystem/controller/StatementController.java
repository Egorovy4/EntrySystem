package entrySystem.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entrySystem.domain.Faculty;
import entrySystem.domain.Statement;
import entrySystem.domain.User;
import entrySystem.service.FacultyService;
import entrySystem.service.RegisteredEntrantService;
import entrySystem.service.StatementService;
import entrySystem.service.UserService;

@Controller
public class StatementController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private RegisteredEntrantService registeredEntrantService;

	@Autowired
	private StatementService statementService;

	@RequestMapping(value = "/entrantSubmiting", method = RequestMethod.POST)
	public ModelAndView entrantSubmiting(@RequestParam("facultyId") Integer facultyId,
			@RequestParam("userId") Integer userId, @RequestParam("entrantId") Integer entrantId) {
		Statement statement = new Statement();

		statement.setUserId(userId);
		statement.setFacultyId(facultyId);
		statement.setStatementMarks(new ArrayList<Double>(registeredEntrantService.findById(entrantId).getMarks()));

		statementService.save(statement);

		registeredEntrantService.deleteById(entrantId);

		ModelAndView modelAndView = new ModelAndView("registeredEntrants");
		modelAndView.addObject("registeredEntrants", registeredEntrantService.findAllRegisteredEntrants());
		return modelAndView;
	}

	@RequestMapping(value = "/rating", method = RequestMethod.GET)
	public ModelAndView showRating(@RequestParam("currentFacultyId") Integer currentFacultyId) {

		List<Statement> listOfAllStatements = statementService.findAllStatements();
		Faculty currentFaculty = facultyService.findFacultyById(currentFacultyId);
		
		List<Statement> statementsOfCurrentFaculty = listOfAllStatements.stream().filter(s -> facultyService.findFacultyById(s.getFacultyId()).getName().equals(currentFaculty.getName())).collect(Collectors.toList());
		
		System.out.println("BEFORE sorting: " + statementsOfCurrentFaculty);
		
		Collections.sort(statementsOfCurrentFaculty);

		statementsOfCurrentFaculty.stream().forEach(statement -> {
			if (statementsOfCurrentFaculty.indexOf(statement) < facultyService.findFacultyById(currentFacultyId).getQuantityOfStudents())
				statement.setAccepted(true);
		});

		System.out.println("After sorting and rating: " + statementsOfCurrentFaculty);

		List<User> usersOfCurrentFaculty = statementsOfCurrentFaculty.stream().map(s -> userService.findUserById(s.getUserId())).collect(Collectors.toList());
		List<Boolean> isUsersAccepted = statementsOfCurrentFaculty.stream().map(s -> s.isAccepted()).collect(Collectors.toList());
		
		
		ModelAndView modelAndView = new ModelAndView("rating");
		modelAndView.addObject("statements", statementsOfCurrentFaculty);
		modelAndView.addObject("users", usersOfCurrentFaculty);
		modelAndView.addObject("faculty", currentFaculty);
		modelAndView.addObject("accepting", isUsersAccepted);
		
		return modelAndView;
	}
}
