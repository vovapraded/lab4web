package backend.academy.lab4web.repository;

import backend.academy.lab4web.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     Optional<User> findByLogin(String login);

     boolean existsByLogin(String login);
}