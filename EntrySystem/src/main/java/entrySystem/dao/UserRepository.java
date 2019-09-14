package entrySystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entrySystem.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}