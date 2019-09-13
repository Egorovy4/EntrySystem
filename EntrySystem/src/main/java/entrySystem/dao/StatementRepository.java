package entrySystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entrySystem.domain.Statement;

public interface StatementRepository extends JpaRepository<Statement, Integer> {
}