package business.impl;

import org.springframework.beans.factory.annotation.Autowired;

import business.CommentService;
import persistence.models.Comment;
import persistence.repositories.CommentRepository;

public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository repository;
	

	@Override
	public void save(Comment comment) {
		// TODO Auto-generated method stub
		repository.save(comment);
		
	}

	@Override
	public void delete(Comment comment) {
		// TODO Auto-generated method stub
		repository.delete(comment);
		
	}

	public CommentRepository getRepository() {
		return repository;
	}

}
