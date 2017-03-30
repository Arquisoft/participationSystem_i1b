package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.CommentService;
import es.uniovi.asw.persistence.model.Comment;
import es.uniovi.asw.persistence.repositories.CommentRepository;

@Service
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
