package entrySystem.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entrySystem.domain.Faculty;
import entrySystem.domain.Subjects;
import entrySystem.domain.User;
import entrySystem.service.FacultyService;
import entrySystem.service.UserService;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private FacultyService facultyService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        return "redirect:/login";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Locale locale, Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Error exists");

        if (logout != null)
            model.addAttribute("message", "Logout = true");
        
        return "login";
    }

    @RequestMapping(value ="/home", method = RequestMethod.GET)
    public ModelAndView welcome() {
    	ModelAndView modelAndView = new ModelAndView("home");
    	modelAndView.addObject("faculties", facultyService.findAllFaculties());
        return modelAndView;
    }
    
    @RequestMapping(value ="/create-faculty", method = RequestMethod.GET)
    public ModelAndView createFaculty() {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("createFaculty");
    	modelAndView.addObject("subjects", Subjects.values());
    	modelAndView.addObject("faculty", new Faculty());
    	return modelAndView;
    }
}
