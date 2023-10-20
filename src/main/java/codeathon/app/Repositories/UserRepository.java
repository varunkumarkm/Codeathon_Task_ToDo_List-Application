package codeathon.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import codeathon.app.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String username);

}
