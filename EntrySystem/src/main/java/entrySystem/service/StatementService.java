package entrySystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrySystem.dao.StatementRepository;
import entrySystem.domain.Statement;

@Service
public class StatementService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private StatementRepository statementRepository;

	public Statement save(Statement statement) {
		logger.info("Create new statement: " + statement);

		return statementRepository.save(statement);
	}

	public List<Statement> findAllStatements() {
		logger.info("Find all statements");

		return statementRepository.findAll();
	}
}
