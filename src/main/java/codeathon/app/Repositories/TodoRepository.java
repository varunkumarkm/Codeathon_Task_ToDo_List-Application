package codeathon.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import codeathon.app.Entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
