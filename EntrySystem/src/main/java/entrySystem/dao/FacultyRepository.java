package entrySystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entrySystem.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
