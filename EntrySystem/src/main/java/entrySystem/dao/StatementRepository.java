package entrySystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entrySystem.domain.Statement;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer> {
		
}
