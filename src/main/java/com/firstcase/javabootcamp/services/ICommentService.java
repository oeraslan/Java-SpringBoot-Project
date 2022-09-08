package com.firstcase.javabootcamp.services;

import java.util.Calendar;
import java.util.List;
import com.firstcase.javabootcamp.entities.Comment;

public interface ICommentService {

	List<Comment> getAll();

	void add(Comment comment);

	void update(Comment comment);

	void delete(long id);

	Comment getById(long id);

	List<Comment> getProductComments(long productID);

	List<Comment> getcommentWithDate(long productID, Calendar start, Calendar finish);

	List<Comment> getUserComments(long userID);

	List<Comment> getUserCommentsWithDate(long userID,Calendar start, Calendar finish);

}
