package entrySystem;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import entrySystem.dao.FacultyRepository;
import entrySystem.dao.RegisteredEntrantRepository;
import entrySystem.dao.StatementRepository;
import entrySystem.dao.UserRepository;
import entrySystem.domain.Faculty;
import entrySystem.domain.RegisteredEntrant;
import entrySystem.domain.Statement;
import entrySystem.domain.Subjects;
import entrySystem.domain.User;
import entrySystem.domain.UserRoles;
import entrySystem.service.FacultyService;
import entrySystem.service.RegisteredEntrantService;
import entrySystem.service.StatementService;
import entrySystem.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntrySystemApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FacultyRepository facultyRepository;

	@Autowired
	private RegisteredEntrantRepository registeredEntrantRepository;

	@Autowired
	private StatementRepository statementRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private RegisteredEntrantService registeredEntrantService;

	@Autowired
	private StatementService statementService;

	@Test
	public void testSaveUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setFirstName("testFirstName");
		user.setSecondName("testSecondName");
		user.setAge(1);
		user.setEmail("test@mail.com");
		user.setPassword("testPassword");
		user.setPasswordConfirm("testPassword");
		user.setRole(UserRoles.ROLE_USER);

		userService.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User userFromDB = users.get(0);
		
		assertTrue(user.getFirstName().equals(userFromDB.getFirstName()));
		assertTrue(user.getSecondName().equals(userFromDB.getSecondName()));
		assertTrue(user.getAge().equals(userFromDB.getAge()));
		assertTrue(user.getEmail().equals(userFromDB.getEmail()));
		assertTrue(user.getPassword().equals(userFromDB.getPassword()));
		assertTrue(user.getPasswordConfirm().equals(userFromDB.getPasswordConfirm()));
		assertTrue(user.getRole().equals(userFromDB.getRole()));
	}
	
	@Test
	public void testFindUserByEmail() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setFirstName("testFirstName");
		user.setSecondName("testSecondName");
		user.setAge(1);
		user.setEmail("test@mail.com");
		user.setPassword("testPassword");
		user.setPasswordConfirm("testPassword");
		user.setRole(UserRoles.ROLE_USER);

		userService.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User userFromDB = userService.findUserByEmail("test@mail.com");
		
		assertTrue(user.getFirstName().equals(userFromDB.getFirstName()));
		assertTrue(user.getSecondName().equals(userFromDB.getSecondName()));
		assertTrue(user.getAge().equals(userFromDB.getAge()));
		assertTrue(user.getEmail().equals(userFromDB.getEmail()));
		assertTrue(user.getPassword().equals(userFromDB.getPassword()));
		assertTrue(user.getPasswordConfirm().equals(userFromDB.getPasswordConfirm()));
		assertTrue(user.getRole().equals(userFromDB.getRole()));
	}
	
	@Test
	public void testFindUserById() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setFirstName("testFirstName");
		user.setSecondName("testSecondName");
		user.setAge(1);
		user.setEmail("test@mail.com");
		user.setPassword("testPassword");
		user.setPasswordConfirm("testPassword");
		user.setRole(UserRoles.ROLE_USER);

		userService.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User userFromDB = userService.findUserById(users.get(0).getId());
		
		assertTrue(user.getFirstName().equals(userFromDB.getFirstName()));
		assertTrue(user.getSecondName().equals(userFromDB.getSecondName()));
		assertTrue(user.getAge().equals(userFromDB.getAge()));
		assertTrue(user.getEmail().equals(userFromDB.getEmail()));
		assertTrue(user.getPassword().equals(userFromDB.getPassword()));
		assertTrue(user.getPasswordConfirm().equals(userFromDB.getPasswordConfirm()));
		assertTrue(user.getRole().equals(userFromDB.getRole()));
	}
	
	@Test
	public void testSaveFaculty() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("testName");
		faculty.setQuantityOfStudents(1);
		faculty.setSubjects(Arrays.asList(Subjects.ENGLISH, Subjects.DEUTSCH, Subjects.UKRAINIAN_LANGUAGE));
		
		facultyService.save(faculty);

		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));
		
		Faculty facultyFromDB = faculties.get(0);
		
		assertTrue(faculty.getName().equals(facultyFromDB.getName()));
		assertTrue(faculty.getQuantityOfStudents().equals(facultyFromDB.getQuantityOfStudents()));
		assertTrue(faculty.getSubjects().equals(facultyFromDB.getSubjects()));
	}
	
	@Test
	public void testFindAllFaculties() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty1 = new Faculty();
		faculty1.setName("testName1");
		faculty1.setQuantityOfStudents(1);
		faculty1.setSubjects(Arrays.asList(Subjects.ENGLISH, Subjects.DEUTSCH, Subjects.UKRAINIAN_LANGUAGE));
		
		Faculty faculty2 = new Faculty();
		faculty2.setName("testName2");
		faculty2.setQuantityOfStudents(2);
		faculty2.setSubjects(Arrays.asList(Subjects.ENGLISH, Subjects.DEUTSCH, Subjects.UKRAINIAN_LANGUAGE));
		
		facultyService.save(faculty1);
		facultyService.save(faculty2);

		faculties = facultyService.findAllFaculties();
		assertThat(faculties, hasSize(2));
		
		assertTrue(faculties.get(0).getName().equals(faculty1.getName()));
		assertTrue(faculties.get(0).getQuantityOfStudents().equals(faculty1.getQuantityOfStudents()));
		assertTrue(faculties.get(0).getSubjects().equals(faculty1.getSubjects()));
		
		assertTrue(faculties.get(1).getName().equals(faculty2.getName()));
		assertTrue(faculties.get(1).getQuantityOfStudents().equals(faculty2.getQuantityOfStudents()));
		assertTrue(faculties.get(1).getSubjects().equals(faculty2.getSubjects()));
	}
	
	@Test
	public void testFindFacultyById() {
		List<Faculty> faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(0));

		Faculty faculty = new Faculty();
		faculty.setName("testName1");
		faculty.setQuantityOfStudents(1);
		faculty.setSubjects(Arrays.asList(Subjects.ENGLISH, Subjects.DEUTSCH, Subjects.UKRAINIAN_LANGUAGE));
		
		facultyService.save(faculty);

		faculties = facultyService.findAllFaculties();
		assertThat(faculties, hasSize(1));
		
		Faculty facultyFromDB = facultyService.findFacultyById(faculties.get(0).getId());
		
		assertTrue(facultyFromDB.getName().equals(faculty.getName()));
		assertTrue(facultyFromDB.getQuantityOfStudents().equals(faculty.getQuantityOfStudents()));
		assertTrue(facultyFromDB.getSubjects().equals(faculty.getSubjects()));
	}
	
	@Test
	public void testSaveRegisteredEntrant() {
		List<User> users = userRepository.findAll();
		List<Faculty> faculties = facultyRepository.findAll();
		List<Double> marks = Arrays.asList(1.1, 2.2, 3.3);
		List<RegisteredEntrant> registeredEntrants = registeredEntrantRepository.findAll();
		
		assertThat(users, hasSize(0));
		assertThat(faculties, hasSize(0));
		assertThat(registeredEntrants, hasSize(0));
		
		User user = new User();
		user.setFirstName("testFirstName");
		user.setSecondName("testSecondName");
		user.setAge(1);
		user.setEmail("test@mail.com");
		user.setPassword("testPassword");
		user.setPasswordConfirm("testPassword");
		user.setRole(UserRoles.ROLE_USER);
		
		userService.save(user);
		users = userRepository.findAll();
		assertThat(users, hasSize(1));
		
		Faculty faculty = new Faculty();
		faculty.setName("testName");
		faculty.setQuantityOfStudents(1);
		faculty.setSubjects(Arrays.asList(Subjects.ENGLISH, Subjects.DEUTSCH, Subjects.UKRAINIAN_LANGUAGE));
		
		facultyService.save(faculty);
		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));
		
		User userFromDB = users.get(0);
		Faculty facultyFromDB = faculties.get(0);
		
		RegisteredEntrant registeredEntrant = new RegisteredEntrant(userFromDB, facultyFromDB, marks);
		registeredEntrant.setEncodedEntrantImage("1");
		
		registeredEntrantService.save(registeredEntrant);
		registeredEntrants = registeredEntrantRepository.findAll();
		assertThat(registeredEntrants, hasSize(1));

		RegisteredEntrant registeredEntrantFromDB = registeredEntrants.get(0);
		
		assertTrue(registeredEntrant.getUser().equals(registeredEntrantFromDB.getUser()));
		assertTrue(registeredEntrant.getFaculty().equals(registeredEntrantFromDB.getFaculty()));
		assertTrue(registeredEntrant.getMarks().equals(registeredEntrantFromDB.getMarks()));
		assertTrue(registeredEntrant.getEncodedEntrantImage().equals(registeredEntrantFromDB.getEncodedEntrantImage()));
	}
	
	@Test
	public void testFindRegisteredEntrantById() {
		List<User> users = userRepository.findAll();
		List<Faculty> faculties = facultyRepository.findAll();
		List<Double> marks = Arrays.asList(1.1, 2.2, 3.3);
		List<RegisteredEntrant> registeredEntrants = registeredEntrantRepository.findAll();
		
		assertThat(users, hasSize(0));
		assertThat(faculties, hasSize(0));
		assertThat(registeredEntrants, hasSize(0));
		
		User user = new User();
		user.setFirstName("testFirstName");
		user.setSecondName("testSecondName");
		user.setAge(1);
		user.setEmail("test@mail.com");
		user.setPassword("testPassword");
		user.setPasswordConfirm("testPassword");
		user.setRole(UserRoles.ROLE_USER);
		
		userService.save(user);
		users = userRepository.findAll();
		assertThat(users, hasSize(1));
		
		Faculty faculty = new Faculty();
		faculty.setName("testName");
		faculty.setQuantityOfStudents(1);
		faculty.setSubjects(Arrays.asList(Subjects.ENGLISH, Subjects.DEUTSCH, Subjects.UKRAINIAN_LANGUAGE));
		
		facultyService.save(faculty);
		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(1));
		
		User userFromDB = users.get(0);
		Faculty facultyFromDB = faculties.get(0);
		
		RegisteredEntrant registeredEntrant = new RegisteredEntrant(userFromDB, facultyFromDB, marks);
		registeredEntrant.setEncodedEntrantImage("1");
		
		registeredEntrantService.save(registeredEntrant);
		registeredEntrants = registeredEntrantRepository.findAll();
		assertThat(registeredEntrants, hasSize(1));

		RegisteredEntrant registeredEntrantFromDB = registeredEntrantService.findById(registeredEntrants.get(0).getId());
		
		assertTrue(registeredEntrant.getUser().equals(registeredEntrantFromDB.getUser()));
		assertTrue(registeredEntrant.getFaculty().equals(registeredEntrantFromDB.getFaculty()));
		assertTrue(registeredEntrant.getMarks().equals(registeredEntrantFromDB.getMarks()));
		assertTrue(registeredEntrant.getEncodedEntrantImage().equals(registeredEntrantFromDB.getEncodedEntrantImage()));
	}
	
	@Test
	public void testFindAllRegisteredEntrants() {
		List<User> users = userRepository.findAll();
		List<Faculty> faculties = facultyRepository.findAll();
		List<Double> marks1 = Arrays.asList(1.1, 2.2, 3.3);
		List<Double> marks2 = Arrays.asList(1.1, 2.2, 3.3);
		List<RegisteredEntrant> registeredEntrants = registeredEntrantRepository.findAll();
		
		assertThat(users, hasSize(0));
		assertThat(faculties, hasSize(0));
		assertThat(registeredEntrants, hasSize(0));
		
		User user1 = new User();
		user1.setFirstName("testFirstName1");
		user1.setSecondName("testSecondName1");
		user1.setAge(1);
		user1.setEmail("test1@mail.com");
		user1.setPassword("testPassword1");
		user1.setPasswordConfirm("testPassword1");
		user1.setRole(UserRoles.ROLE_USER);
		
		User user2 = new User();
		user2.setFirstName("testFirstName2");
		user2.setSecondName("testSecondName2");
		user2.setAge(2);
		user2.setEmail("test2@mail.com");
		user2.setPassword("testPassword2");
		user2.setPasswordConfirm("testPassword2");
		user2.setRole(UserRoles.ROLE_USER);
		
		userService.save(user1);
		userService.save(user2);
		users = userRepository.findAll();
		assertThat(users, hasSize(2));
		
		Faculty faculty1 = new Faculty();
		faculty1.setName("testName1");
		faculty1.setQuantityOfStudents(1);
		faculty1.setSubjects(Arrays.asList(Subjects.ENGLISH, Subjects.DEUTSCH, Subjects.UKRAINIAN_LANGUAGE));
		
		Faculty faculty2 = new Faculty();
		faculty2.setName("testName2");
		faculty2.setQuantityOfStudents(2);
		faculty2.setSubjects(Arrays.asList(Subjects.ENGLISH, Subjects.DEUTSCH, Subjects.UKRAINIAN_LANGUAGE));
		
		facultyService.save(faculty1);
		facultyService.save(faculty2);
		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(2));
		
		RegisteredEntrant registeredEntrant1 = new RegisteredEntrant(users.get(0), faculties.get(0), marks1);
		registeredEntrant1.setEncodedEntrantImage("1");
		
		RegisteredEntrant registeredEntrant2 = new RegisteredEntrant(users.get(1), faculties.get(1), marks2);
		registeredEntrant2.setEncodedEntrantImage("2");
		
		registeredEntrantService.save(registeredEntrant1);
		registeredEntrantService.save(registeredEntrant2);
		List<RegisteredEntrant> registeredEntrantsFromDB = registeredEntrantService.findAllRegisteredEntrants();
		assertThat(registeredEntrantsFromDB, hasSize(2));
		
		assertTrue(registeredEntrant1.getUser().equals(registeredEntrantsFromDB.get(0).getUser()));
		assertTrue(registeredEntrant1.getFaculty().equals(registeredEntrantsFromDB.get(0).getFaculty()));
		assertTrue(registeredEntrant1.getMarks().equals(registeredEntrantsFromDB.get(0).getMarks()));
		assertTrue(registeredEntrant1.getEncodedEntrantImage().equals(registeredEntrantsFromDB.get(0).getEncodedEntrantImage()));
		
		assertTrue(registeredEntrant2.getUser().equals(registeredEntrantsFromDB.get(1).getUser()));
		assertTrue(registeredEntrant2.getFaculty().equals(registeredEntrantsFromDB.get(1).getFaculty()));
		assertTrue(registeredEntrant2.getMarks().equals(registeredEntrantsFromDB.get(1).getMarks()));
		assertTrue(registeredEntrant2.getEncodedEntrantImage().equals(registeredEntrantsFromDB.get(1).getEncodedEntrantImage()));
	}
	
	@Test
	public void testDeleteRegisteredEntrantById() {
		List<User> users = userRepository.findAll();
		List<Faculty> faculties = facultyRepository.findAll();
		List<Double> marks1 = Arrays.asList(1.1, 2.2, 3.3);
		List<Double> marks2 = Arrays.asList(1.1, 2.2, 3.3);
		List<RegisteredEntrant> registeredEntrants = registeredEntrantRepository.findAll();
		
		assertThat(users, hasSize(0));
		assertThat(faculties, hasSize(0));
		assertThat(registeredEntrants, hasSize(0));
		
		User user1 = new User();
		user1.setFirstName("testFirstName1");
		user1.setSecondName("testSecondName1");
		user1.setAge(1);
		user1.setEmail("test1@mail.com");
		user1.setPassword("testPassword1");
		user1.setPasswordConfirm("testPassword1");
		user1.setRole(UserRoles.ROLE_USER);
		
		User user2 = new User();
		user2.setFirstName("testFirstName2");
		user2.setSecondName("testSecondName2");
		user2.setAge(2);
		user2.setEmail("test2@mail.com");
		user2.setPassword("testPassword2");
		user2.setPasswordConfirm("testPassword2");
		user2.setRole(UserRoles.ROLE_USER);
		
		userService.save(user1);
		userService.save(user2);
		users = userRepository.findAll();
		assertThat(users, hasSize(2));
		
		Faculty faculty1 = new Faculty();
		faculty1.setName("testName1");
		faculty1.setQuantityOfStudents(1);
		faculty1.setSubjects(Arrays.asList(Subjects.ENGLISH, Subjects.DEUTSCH, Subjects.UKRAINIAN_LANGUAGE));
		
		Faculty faculty2 = new Faculty();
		faculty2.setName("testName2");
		faculty2.setQuantityOfStudents(2);
		faculty2.setSubjects(Arrays.asList(Subjects.ENGLISH, Subjects.DEUTSCH, Subjects.UKRAINIAN_LANGUAGE));
		
		facultyService.save(faculty1);
		facultyService.save(faculty2);
		faculties = facultyRepository.findAll();
		assertThat(faculties, hasSize(2));
		
		RegisteredEntrant registeredEntrant1 = new RegisteredEntrant(users.get(0), faculties.get(0), marks1);
		registeredEntrant1.setEncodedEntrantImage("1");
		
		RegisteredEntrant registeredEntrant2 = new RegisteredEntrant(users.get(1), faculties.get(1), marks2);
		registeredEntrant2.setEncodedEntrantImage("2");
		
		registeredEntrantService.save(registeredEntrant1);
		registeredEntrantService.save(registeredEntrant2);
		List<RegisteredEntrant> registeredEntrantsFromDB = registeredEntrantService.findAllRegisteredEntrants();
		assertThat(registeredEntrantsFromDB, hasSize(2));
		
		registeredEntrantService.deleteById(registeredEntrantsFromDB.get(0).getId());
		
		registeredEntrantsFromDB = registeredEntrantRepository.findAll();
		
		assertThat(registeredEntrantsFromDB, hasSize(1));
		assertTrue(registeredEntrant2.getUser().equals(registeredEntrantsFromDB.get(0).getUser()));
		assertTrue(registeredEntrant2.getFaculty().equals(registeredEntrantsFromDB.get(0).getFaculty()));
		assertTrue(registeredEntrant2.getMarks().equals(registeredEntrantsFromDB.get(0).getMarks()));
		assertTrue(registeredEntrant2.getEncodedEntrantImage().equals(registeredEntrantsFromDB.get(0).getEncodedEntrantImage()));
	}
	
	@Test
	public void testSaveStatement() {
		List<Statement> statements = statementRepository.findAll();
		assertThat(statements, hasSize(0));

		Statement statement = new Statement();
		statement.setUserId(1);
		statement.setFacultyId(1);
		statement.setStatementMarks(Arrays.asList(1.1, 2.2, 3.3));
		
		statementService.save(statement);
		statements = statementRepository.findAll();
		assertThat(statements, hasSize(1));

		Statement statementFromDB = statements.get(0);
		
		assertTrue(statement.getUserId().equals(statementFromDB.getUserId()));
		assertTrue(statement.getFacultyId().equals(statementFromDB.getFacultyId()));
		assertTrue(statement.getStatementMarks().equals(statementFromDB.getStatementMarks()));
	}

	@Test
	public void testFindAllStatements() {
		List<Statement> statements = statementRepository.findAll();
		assertThat(statements, hasSize(0));

		Statement statement1 = new Statement();
		statement1.setUserId(1);
		statement1.setFacultyId(1);
		statement1.setStatementMarks(Arrays.asList(1.1, 2.2, 3.3));
		
		Statement statement2 = new Statement();
		statement2.setUserId(2);
		statement2.setFacultyId(2);
		statement2.setStatementMarks(Arrays.asList(12.12, 22.22, 32.32));
		
		statementService.save(statement1);
		statementService.save(statement2);

		List<Statement> statementsFromDB = statementService.findAllStatements();
	
		assertThat(statementsFromDB, hasSize(2));
		
		assertTrue(statement1.getUserId().equals(statementsFromDB.get(0).getUserId()));
		assertTrue(statement1.getFacultyId().equals(statementsFromDB.get(0).getFacultyId()));
		assertTrue(statement1.getStatementMarks().equals(statementsFromDB.get(0).getStatementMarks()));
		
		assertTrue(statement2.getUserId().equals(statementsFromDB.get(1).getUserId()));
		assertTrue(statement2.getFacultyId().equals(statementsFromDB.get(1).getFacultyId()));
		assertTrue(statement2.getStatementMarks().equals(statementsFromDB.get(1).getStatementMarks()));
	}
}
