package es.uniovi.asw.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.asw.persistence.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
