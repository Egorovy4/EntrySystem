package entrySystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entrySystem.dao.StatementRepository;
import entrySystem.domain.Statement;

@Service
public class StatementService {

	@Autowired
	private StatementRepository statementRepository;

	public void save(Statement statement) {
		statementRepository.save(statement);
	}

	public Statement findById(Integer id) {
		return statementRepository.findById(id).get();
	}

	public List<Statement> findAllStatements() {
		return statementRepository.findAll();
	}
}
