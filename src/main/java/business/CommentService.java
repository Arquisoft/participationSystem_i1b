package business;

import persistence.models.Comment;

public interface CommentService {
	void save(Comment coment);
	void delete(Comment coment);
	

}
