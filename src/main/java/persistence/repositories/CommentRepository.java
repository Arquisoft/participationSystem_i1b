package persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import persistence.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
