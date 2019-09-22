package entrySystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entrySystem.domain.RegisteredEntrant;

public interface RegisteredEntrantRepository extends JpaRepository<RegisteredEntrant, Integer> {
}