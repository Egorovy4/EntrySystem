package entrySystem.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import entrySystem.domain.Faculty;
import entrySystem.domain.RegisteredEntrant;
import entrySystem.domain.User;
import entrySystem.service.FacultyService;
import entrySystem.service.RegisteredEntrantService;
import entrySystem.service.UserService;

@Controller
public class RegisteredEntrantController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private RegisteredEntrantService registeredEntrantService;
	
	@RequestMapping(value = "/entrantRegistration", method = RequestMethod.GET)
	public ModelAndView showSubjects(@RequestParam("currentFacultyId") Integer currentFacultyId, @RequestParam("currentUserEmail") String currentUserEmail) {
		Faculty faculty = facultyService.findFacultyById(currentFacultyId);
		User user = userService.findUserByEmail(currentUserEmail);
		
		RegisteredEntrant registeredEntrant = new RegisteredEntrant();
		registeredEntrant.setFaculty(faculty);
		registeredEntrant.setUser(user);
		
		ModelAndView modelAndView = new ModelAndView("entrantRegistration");
		
		modelAndView.addObject("registeredEntrant", registeredEntrant);
		return modelAndView;
	}
	
	@RequestMapping(value = "/addMarks", method = RequestMethod.POST)
	public String registration(@RequestParam MultipartFile image, @RequestParam List<Double> marks, @RequestParam Integer facultyId, @RequestParam String userEmail) throws IOException {
		Faculty faculty = facultyService.findFacultyById(facultyId);
		User user = userService.findUserByEmail(userEmail);
		
		RegisteredEntrant registeredEntrant = new RegisteredEntrant(user, faculty, marks);
		registeredEntrant.setEncodedEntrantImage(Base64.getEncoder().encodeToString(image.getBytes()));
		
		registeredEntrantService.save(registeredEntrant);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/registeredEntrants", method = RequestMethod.GET)
	public ModelAndView showRating() {
		ModelAndView modelAndView = new ModelAndView("registeredEntrants");
		modelAndView.addObject("registeredEntrants", registeredEntrantService.findAllRegisteredEntrants());
		return modelAndView;
	}
}
